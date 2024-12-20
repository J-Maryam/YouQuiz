package org.youcode.youquiz.dtos.quizAssignment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record QuizAssignmentRequestDTO(
        @NotBlank
        String reason,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate,
        int attempt,
        double score,
        String result,
        @NotNull
        Long quizId,
        @NotNull
        Long studentId
) {
}
