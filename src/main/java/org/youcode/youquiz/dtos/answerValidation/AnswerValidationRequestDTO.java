package org.youcode.youquiz.dtos.answerValidation;

import jakarta.validation.constraints.NotNull;

public record AnswerValidationRequestDTO(
        @NotNull
        double points,
        @NotNull
        Long questionId,
        @NotNull
        Long answerId,
        @NotNull
        Long quizId,
        @NotNull
        Long studentId
) {
}
