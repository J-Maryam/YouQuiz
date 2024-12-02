package org.youcode.youquiz.dtos.participation;

import org.youcode.youquiz.dtos.level.EmbeddableLevelDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.student.EmbeddableStudentDTO;
import org.youcode.youquiz.dtos.subject.EmbeddableSubjectDTO;
import org.youcode.youquiz.dtos.trainer.EmbeddableTrainerDTO;
import org.youcode.youquiz.entities.Answer;
import org.youcode.youquiz.entities.enums.QuestionType;

import java.time.LocalDate;
import java.util.List;

public record ParticipationResultDTO(
        QuizResultDTO quizId,
        StudentResultDTO studentId,
        double score,
        String result,
        LocalDate startDate,
        LocalDate endDate,
        List<ResultQuestionDTO> questions
//        List<ResultAnswersDTO> answers
) {
    public record QuizResultDTO(
            String title,
            double successScore,
            String remark,
            TrainerResultDTO trainer
    ) {
    }

    public record TrainerResultDTO(
            String firstName,
            String lastName,
            String speciality
    ) {
    }

    public record StudentResultDTO(
            String firstName,
            String lastName
    ) {
    }

    public record ResultAnswersDTO(
            double points
//            EmbeddableQuestionDTO question,
//            List<Answer> answers
    ) {
    }

    public record ResultQuestionDTO(
            String text,
            QuestionType questionType
//            EmbeddableSubjectDTO subject,
//            EmbeddableLevelDTO level
    ) {
    }
}
