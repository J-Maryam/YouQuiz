package org.youcode.youquiz.dtos.participation;

import java.time.LocalDateTime;
import java.util.List;

public record ParticipateRequestDTO(
        Long quizId,
        Long studentId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        List<StudentAnswerDTO> answers
) {
}
