package org.youcode.youquiz.dtos.level;

import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;

import java.util.List;

public record LevelResponseDTO(
        Long id,
        String description,
        Integer minPoints,
        Integer maxPoints,
        List<EmbeddableQuestionDTO> questions
) {
}
