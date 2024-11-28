package org.youcode.youquiz.dtos.answerValidation;

public record AnswerValidationRequestDTO(
        double point,
        Long questionId,
        Long answerId
) {
}
