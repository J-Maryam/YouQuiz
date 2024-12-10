package org.youcode.youquiz.dtos.participation;

import org.youcode.youquiz.entities.enums.QuestionType;

import java.time.LocalDate;
import java.util.List;

public record ParticipationResultDTO(
        String quizTitle,
        String studentName,
        LocalDate startDate,
        LocalDate endDate,
        double score,
        String result,
        int attempt,
        List<ValidationAnswerDTO> answers
) {
    public record ValidationAnswerDTO(
            String question,
            String givenAnswer,
            double points
    ) {}
}



//
//public record ParticipationResultDTO(
//        QuizResultDTO quiz,
//        StudentResultDTO student,
//        double score,
//        String result,
//        LocalDate startDate,
//        LocalDate endDate,
//        List<ResultQuestionDTO> questions
//) {
//    public record QuizResultDTO(
//            String title,
//            double successScore,
//            String remark,
//            TrainerResultDTO trainer
//    ) {
//    }
//
//    public record TrainerResultDTO(
//            String firstName,
//            String lastName,
//            String speciality
//    ) {
//    }
//
//    public record StudentResultDTO(
//            String firstName,
//            String lastName
//    ) {
//    }
//
//    public record ResultQuestionDTO(
//            Long questionId,
//            String questionText,
//            QuestionType questionType,
//            double pointsAwarded, // Points obtenus pour cette question
//            List<ResultAnswerDTO> answers // Réponses données par l'étudiant
//    ) {
//    }
//
//    public record ResultAnswerDTO(
//            Long answerId,
//            String answerText,
//            boolean isCorrect,
//            double points
//    ) {
//    }
//}
