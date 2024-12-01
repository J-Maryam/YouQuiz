package org.youcode.youquiz.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;
import org.youcode.youquiz.dtos.participation.StudentAnswerDTO;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.entities.enums.ResultType;
import org.youcode.youquiz.repositories.AnswerValidationRepository;
import org.youcode.youquiz.repositories.QuestionHasAnswersRepository;
import org.youcode.youquiz.repositories.QuizAssignmentRepository;
import org.youcode.youquiz.services.QuizParticipateService;

import java.time.LocalDateTime;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class QuizParticipateServiceImpl implements QuizParticipateService {

    private final QuizAssignmentRepository quizAssignmentRepository;
    private final AnswerValidationRepository answerValidationRepository;
    private final QuestionHasAnswersRepository questionHasAnswersRepository;

    @Override
    public void participate(ParticipateRequestDTO dto) {

        QuizAssignment quizAssignment = validateQuizAssignment(dto);

        double totalScore = insertStudentAnswers(dto);
        updateQuizAssignment(quizAssignment, totalScore, quizAssignment.getQuiz());

    }

    private QuizAssignment validateQuizAssignment(ParticipateRequestDTO dto) {
        QuizAssignment quizAssignment = quizAssignmentRepository.findById(new QuizAssignmentId(dto.quizId(), dto.studentId()))
                .orElseThrow(() -> new IllegalArgumentException("Quiz assignment not found"));

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(quizAssignment.getStartDate().atStartOfDay()) ||
                now.isAfter(quizAssignment.getEndDate().atTime(23, 59))) {
            throw new IllegalArgumentException("Quiz participation is not within valid dates");
        }

        return quizAssignment;
    }

    private double insertStudentAnswers(ParticipateRequestDTO dto) {
        return dto.answers().stream()
                .flatMap(answer -> answer.selectedAnswerIds().stream()
                        .map(answerId -> {
                            QuestionHasAnswers questionHasAnswers = questionHasAnswersRepository
                                    .findById(new QuestionHasAnswersId(answer.questionId(), answerId))
                                    .orElseThrow(() -> new IllegalArgumentException("Invalid question or answer"));

                            boolean isCorrect = questionHasAnswers.isCorrect();
                            double points = isCorrect ? questionHasAnswers.getNote() : 0;

                            AnswerValidation answerValidation = new AnswerValidation();
                            answerValidation.setQuestion(questionHasAnswers.getQuestion());
                            answerValidation.setAnswer(questionHasAnswers.getAnswer());
                            answerValidation.setPoints(points);

                            answerValidationRepository.save(answerValidation);

                            return points;
                        }))
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private void updateQuizAssignment(QuizAssignment quizAssignment, double totalScore, Quiz quiz) {
        quizAssignment.setScore(totalScore);
        ResultType result = totalScore >= quiz.getSuccessScore() ? ResultType.SUCCESS : ResultType.FAILURE;
        quizAssignment.setResult(result.toString());
        quizAssignmentRepository.save(quizAssignment);
    }

}
