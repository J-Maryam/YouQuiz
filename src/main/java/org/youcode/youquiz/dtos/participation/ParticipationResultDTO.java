package org.youcode.youquiz.dtos.participation;

import java.time.LocalDate;

public record ParticipationResultDTO(
        Long quizId,
        Long studentId,
        double totalScore,
        LocalDate startDate,
        LocalDate endDate,
        String result
) {
}
