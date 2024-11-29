package org.youcode.youquiz.dtos.answerValidation;

import org.youcode.youquiz.dtos.answer.EmbeddableAnswerDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;

public record AnswerValidationResponseDTO(
        double points,
        EmbeddableQuestionDTO question,
        EmbeddableAnswerDTO answer
) {
}
