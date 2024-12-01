package org.youcode.youquiz.dtos.answerValidation;

import org.youcode.youquiz.dtos.answer.EmbeddableAnswerDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.dtos.student.EmbeddableStudentDTO;

public record EmbeddableAnswerValidationDTO(
        double points,
        EmbeddableQuestionDTO question,
        EmbeddableAnswerDTO answer,
        EmbeddableQuizDTO quiz,
        EmbeddableStudentDTO student
) {
}
