package org.youcode.youquiz.dtos.answerValidation;

public record AnswerValidationRequestDTO(
        double points,
        Long questionId,
        Long answerId
) {
}
