package org.youcode.youquiz.dtos.answer;

import org.youcode.youquiz.dtos.answerValidation.EmbeddableAnswerValidationDTO;

import java.util.List;

public record EmbeddableAnswerDTO(
        Long id,
        String text,
        List<EmbeddableAnswerValidationDTO> answerValidations
) {
}
