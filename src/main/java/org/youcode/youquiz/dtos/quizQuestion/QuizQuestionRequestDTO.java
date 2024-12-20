package org.youcode.youquiz.dtos.quizQuestion;

import jakarta.validation.constraints.NotNull;

public record QuizQuestionRequestDTO(
        int timer,
        @NotNull
        Long quizId,
        @NotNull
        Long questionId
) {
}
