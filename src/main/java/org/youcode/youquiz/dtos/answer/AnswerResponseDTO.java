package org.youcode.youquiz.dtos.answer;

import org.youcode.youquiz.dtos.answerValidation.EmbeddableAnswerValidationDTO;

import java.util.List;

public record AnswerResponseDTO(
        Long id,
        String text,
        List<EmbeddableAnswerValidationDTO> answerValidations
) {
}
