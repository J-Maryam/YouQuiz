package org.youcode.youquiz.dtos.quizAssignment;

import java.time.LocalDate;

public record QuizAssignmentRequestDTO(
        String reason,
        LocalDate startDate,
        LocalDate endDate,
        int attempt,
        double score,
        String result,
        Long quizId,
        Long studentId
) {
}
