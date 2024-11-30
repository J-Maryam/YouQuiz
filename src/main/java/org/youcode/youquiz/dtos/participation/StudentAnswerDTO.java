package org.youcode.youquiz.dtos.participation;

import java.util.List;

public record StudentAnswerDTO(
        Long questionId,
        List<Long> selectedAnswerIds
) {
}
