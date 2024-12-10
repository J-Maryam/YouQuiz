package org.youcode.youquiz.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;
import org.youcode.youquiz.dtos.participation.QuizResultDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.*;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.entities.enums.ResultType;
import org.youcode.youquiz.repositories.AnswerValidationRepository;
import org.youcode.youquiz.repositories.QuestionHasAnswersRepository;
import org.youcode.youquiz.repositories.QuizAssignmentRepository;
import org.youcode.youquiz.repositories.QuizQuestionRepository;
import org.youcode.youquiz.services.QuizParticipateService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class QuizParticipateServiceImpl implements QuizParticipateService {

    private final QuizAssignmentRepository quizAssignmentRepository;
    private final AnswerValidationRepository answerValidationRepository;
    private final QuestionHasAnswersRepository questionHasAnswersRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    @Override
    public void participate(ParticipateRequestDTO dto) {

        QuizAssignment quizAssignment = validateQuizAssignment(dto);

        double totalScore = insertStudentAnswers(dto);
        updateQuizAssignment(quizAssignment, totalScore, quizAssignment.getQuiz());

    }

    @Override
    public ParticipationResultDTO getQuizResult(Long assignmentId, Long studentId) {
        // Récupérer l'affectation QuizAssignment via repository
        QuizAssignment assignment = quizAssignmentRepository.findByQuizIdAndStudentId(assignmentId, studentId)
                .orElseThrow(() -> new EntityNotFoundException("Aucune affectation trouvée pour cet étudiant et ce quiz."));

        // Construire le DTO directement
        return new ParticipationResultDTO(
                assignment.getQuiz().getTitle(),
                assignment.getStudent().getFirstName() + " " + assignment.getStudent().getLastName(),
                assignment.getStartDate(),
                assignment.getEndDate(),
                assignment.getScore(),
                assignment.getResult(),
                assignment.getAttempt(),
                assignment.getAnswerValidations().stream()
                        .map(av -> new ParticipationResultDTO.ValidationAnswerDTO(
                                av.getQuestion().getText(),
                                av.getAnswer().getText(),
                                av.getPoints()
                        )).collect(Collectors.toList())
        );
    }


//    @Override
//    public ParticipationResultDTO getQuizResult(Long quizId, Long studentId) {
//        // Récupérer les réponses validées pour l'étudiant et le quiz donné
//        List<AnswerValidation> validations = answerValidationRepository.findByQuizIdAndStudentId(quizId, studentId);
//
//        if (validations.isEmpty()) {
//            throw new EntityNotFoundException("Aucune participation trouvée pour cet étudiant dans ce quiz.");
//        }
//
//        // Récupérer l'entité QuizAssignment associée
//        QuizAssignment quizAssignment = quizAssignmentRepository.findByQuizIdAndStudentId(quizId, studentId)
//                .orElseThrow(() -> new EntityNotFoundException("Aucun QuizAssignment trouvé pour cet étudiant dans ce quiz."));
//
//        // Construire les ResultQuestionDTO à partir des validations
//        List<ParticipationResultDTO.ResultQuestionDTO> resultQuestions = validations.stream()
//                .map(validation -> {
//                    Question question = validation.getQuestion();
//
//                    // Mapper les réponses données par l'étudiant
//                    List<ParticipationResultDTO.ResultAnswerDTO> studentAnswers = List.of(
//                            new ParticipationResultDTO.ResultAnswerDTO(
//                                    validation.getAnswer().getId(),
//                                    validation.getAnswer().getText(),
//                                    questionHasAnswersRepository.isAnswerCorrect(validation.getQuestion().getId(), validation.getAnswer().getId()),
//                                    validation.getPoints()
//                            )
//                    );
//
//                    // Créer un ResultQuestionDTO
//                    return new ParticipationResultDTO.ResultQuestionDTO(
//                            question.getId(),
//                            question.getText(),
//                            question.getQuestionType(),
//                            validation.getPoints(), // Points obtenus par l'étudiant pour cette question
//                            studentAnswers // Réponses données par l'étudiant
//                    );
//                })
//                .toList();
//
//        // Construire les informations du quiz et de l'étudiant
//        Quiz quiz = quizAssignment.getQuiz();
//        Student student = quizAssignment.getStudent();
//
//        // Retourner le DTO final
//        return new ParticipationResultDTO(
//                new ParticipationResultDTO.QuizResultDTO(
//                        quiz.getTitle(),
//                        quiz.getSuccessScore(),
//                        quiz.getRemark(),
//                        new ParticipationResultDTO.TrainerResultDTO(
//                                quiz.getTrainer().getFirstName(),
//                                quiz.getTrainer().getLastName(),
//                                quiz.getTrainer().getSpecialty()
//                        )
//                ),
//                new ParticipationResultDTO.StudentResultDTO(
//                        student.getFirstName(),
//                        student.getLastName()
//                ),
//                quizAssignment.getScore(), // Score directement depuis QuizAssignment
//                quizAssignment.getResult(), // Résultat directement depuis QuizAssignment
//                quizAssignment.getStartDate(),
//                quizAssignment.getEndDate(),
//                resultQuestions // Liste des questions et réponses données
//        );
//    }

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
                    if (!quizQuestionRepository.existsByQuizIdAndQuestionId(dto.quizId(), answer.questionId())) {
                        throw new IllegalArgumentException("La question avec l'ID " + answer.questionId() + " n'est pas associée au quiz ID " + dto.quizId());
                    }

                    List<QuestionHasAnswers> questionAnswers = answer.selectedAnswerIds().stream()
                            .map(answerId -> questionHasAnswersRepository.findById(new QuestionHasAnswersId(answer.questionId(), answerId))
                                    .orElseThrow(() -> new IllegalArgumentException("Invalid question or answer: question: "+ answer.questionId() + ", answerId = " + answerId)))
                            .toList();

                    QuizAssignment quizAssignment = quizAssignmentRepository.findById(new QuizAssignmentId(dto.quizId(), dto.studentId()))
                            .orElseThrow(() -> new IllegalArgumentException("Quiz assignment with QuizId: " +dto.quizId() + " and StudentId: " + dto.studentId() + " not found"));

                    boolean allCorrect = questionAnswers.stream().allMatch(QuestionHasAnswers::isCorrect);

                    double questionPoints = 0;
                    if (allCorrect) {
                        questionPoints = questionAnswers.stream()
                                .mapToDouble(QuestionHasAnswers::getNote)
                                .sum();
                    }

                    questionAnswers.forEach(questionHasAnswer -> {
//                        boolean isCorrect = questionHasAnswer.isCorrect();
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
