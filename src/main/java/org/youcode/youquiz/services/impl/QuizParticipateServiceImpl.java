package org.youcode.youquiz.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;
import org.youcode.youquiz.dtos.participation.QuizResultDTO;
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
import java.util.List;

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

    @Override
    public ParticipationResultDTO getQuizResult(Long quizId, Long studentId) {
        QuizAssignment quizAssignment = quizAssignmentRepository
                .findById(new QuizAssignmentId(quizId, studentId))
                .orElseThrow(() -> new IllegalArgumentException("No participation found for this student in the quiz"));

        Quiz quiz = quizAssignment.getQuiz();

        ParticipationResultDTO.QuizResultDTO quizResultDTO = new ParticipationResultDTO.QuizResultDTO(
                quiz.getTitle(),
                quiz.getSuccessScore(),
                quiz.getRemark(),
                new ParticipationResultDTO.TrainerResultDTO(
                        quiz.getTrainer().getFirstName(),
                        quiz.getTrainer().getLastName(),
                        quiz.getTrainer().getSpecialty()
                )
        );

        ParticipationResultDTO.StudentResultDTO studentResultDTO = new ParticipationResultDTO.StudentResultDTO(
                quizAssignment.getStudent().getFirstName(),
                quizAssignment.getStudent().getLastName()
        );

        List<ParticipationResultDTO.ResultQuestionDTO> questions = quiz.getQuizQuestions().stream()
                .map(question -> new ParticipationResultDTO.ResultQuestionDTO(
                        question.getQuestion().getText(),
                        question.getQuestion().getQuestionType()
                ))
                .toList();


        return new ParticipationResultDTO(
                quizResultDTO,
                studentResultDTO,
                quizAssignment.getScore(),
                quizAssignment.getResult(),
                quizAssignment.getStartDate(),
                quizAssignment.getEndDate(),
                questions
//                answers
        );
    }

    @Override
    public QuizResultDTO getQuizResultsByQuiz(Long quizId) {
        List<QuizAssignment> assignments = quizAssignmentRepository.findByQuizId(quizId);

        if (assignments.isEmpty()) {
            throw new IllegalArgumentException("No results found for the given quiz ID: " + quizId);
        }

        String title = assignments.get(0).getQuiz().getTitle();
        double successScore = assignments.get(0).getQuiz().getSuccessScore();

        List<QuizResultDTO.StudentResultDTO> studentResults = assignments.stream()
                .map(assignment -> new QuizResultDTO.StudentResultDTO(
                        assignment.getStudent().getId(),
                        assignment.getStudent().getFirstName(),
                        assignment.getStudent().getLastName(),
                        assignment.getScore(),
                        assignment.getResult(),
                        assignment.getAttempt()
                ))
                .toList();

        return new QuizResultDTO(title, successScore, studentResults);
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
                .mapToDouble(answer -> {
                    List<QuestionHasAnswers> questionAnswers = answer.selectedAnswerIds().stream()
                            .map(answerId -> questionHasAnswersRepository.findById(new QuestionHasAnswersId(answer.questionId(), answerId))
                                    .orElseThrow(() -> new IllegalArgumentException("Invalid question or answer")))
                            .toList();

                    QuizAssignment quizAssignment = quizAssignmentRepository.findById(new QuizAssignmentId(dto.quizId(), dto.studentId()))
                            .orElseThrow(() -> new IllegalArgumentException("Quiz assignment not found"));

                    boolean allCorrect = questionAnswers.stream().allMatch(QuestionHasAnswers::isCorrect);

                    double questionPoints = 0;
                    if (allCorrect) {
                        questionPoints = questionAnswers.stream()
                                .mapToDouble(QuestionHasAnswers::getNote)
                                .sum();
                    }

                    questionAnswers.forEach(questionHasAnswer -> {
                        boolean isCorrect = questionHasAnswer.isCorrect();
                        double points = allCorrect ? questionHasAnswer.getNote() : 0;

                        AnswerValidation answerValidation = new AnswerValidation();
                        answerValidation.setQuestion(questionHasAnswer.getQuestion());
                        answerValidation.setAnswer(questionHasAnswer.getAnswer());
                        answerValidation.setQuiz(quizAssignment.getQuiz());
                        answerValidation.setStudent(quizAssignment.getStudent());
                        answerValidation.setPoints(points);

                        answerValidationRepository.save(answerValidation);
                    });

                    return questionPoints;
                })
                .sum();
    }

    private void updateQuizAssignment(QuizAssignment quizAssignment, double totalScore, Quiz quiz) {
        quizAssignment.setScore(totalScore);
        ResultType result = totalScore >= quiz.getSuccessScore() ? ResultType.SUCCESS : ResultType.FAILURE;
        quizAssignment.setResult(result.toString());
        quizAssignment.setAttempt(quizAssignment.getAttempt() + 1);
        quizAssignmentRepository.save(quizAssignment);
    }

}
