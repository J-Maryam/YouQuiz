package org.youcode.youquiz.dtos.participation;

import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;

import java.time.LocalDate;
import java.util.List;

public record ParticipationResultDTO(
        Long quizId,
        Long studentId,
        double score,
        String result,
        LocalDate startDate,
        LocalDate endDate,
        List<AnswerValidationResponseDTO> answerValidation
) {
}
