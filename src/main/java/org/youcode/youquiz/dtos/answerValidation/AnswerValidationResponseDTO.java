package org.youcode.youquiz.dtos.answerValidation;

import org.youcode.youquiz.dtos.answer.EmbeddableAnswerDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;

public record AnswerValidationResponseDTO(
        double point,
        EmbeddableQuestionDTO question,
        EmbeddableAnswerDTO answer
) {
}
