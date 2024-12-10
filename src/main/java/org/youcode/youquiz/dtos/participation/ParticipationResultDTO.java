package org.youcode.youquiz.dtos.participation;

import java.time.LocalDate;
import java.util.List;

public record ParticipationResultDTO(
        String quizTitle,
        String studentName,
        LocalDate startDate,
        LocalDate endDate,
        double score,
        String result,
        int attempt,
        List<ValidationAnswerDTO> answers
) {
    public record ValidationAnswerDTO(
            String question,
            String givenAnswer,
            double points
    ) {}
}