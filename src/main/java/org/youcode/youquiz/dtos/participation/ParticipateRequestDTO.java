package org.youcode.youquiz.dtos.participation;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ParticipateRequestDTO(
        @NotNull
        Long quizId,
        @NotNull
        Long studentId,
        List<StudentAnswerDTO> answers
) {
}
