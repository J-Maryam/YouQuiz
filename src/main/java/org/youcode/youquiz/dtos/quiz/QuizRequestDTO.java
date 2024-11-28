package org.youcode.youquiz.dtos.quiz;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record QuizRequestDTO(
        @NotBlank
        String title,

        @NotNull
        double successScore,
        @NotNull
        boolean canSeeAnswers,
        @NotNull
        boolean canSeeResult,

        @NotNull
        @Positive
        Integer numberOfAttempts,

        @NotBlank
        String remark,
        @NotNull
        Long trainerId
) {
}
