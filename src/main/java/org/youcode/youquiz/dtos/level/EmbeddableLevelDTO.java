package org.youcode.youquiz.dtos.level;

public record EmbeddableLevelDTO(
        Long id,
        String description,
        Integer minPoints,
        Integer maxPoints
) {
}
