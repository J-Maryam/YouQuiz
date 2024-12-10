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
        List<QuestionDTO> questions
) {
    public record QuestionDTO(
            String question,
            double totalPoints,
            List<AnswerDTO> answers
    ) {}

    public record AnswerDTO(
            String givenAnswer
    ) {}
}
