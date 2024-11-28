package org.youcode.youquiz.dtos.level;

public record LevelRequestDTO(
        String description,
        Integer minPoints,
        Integer maxPoints
) {
}
