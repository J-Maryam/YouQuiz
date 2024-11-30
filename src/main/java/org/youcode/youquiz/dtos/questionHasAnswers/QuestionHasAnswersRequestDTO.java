package org.youcode.youquiz.dtos.questionHasAnswers;

import jakarta.validation.constraints.NotNull;

public record QuestionHasAnswersRequestDTO(
        @NotNull
        boolean correct,
        @NotNull
        double note,
        @NotNull
        Long questionId,
        @NotNull
        Long answerId
) {
}
