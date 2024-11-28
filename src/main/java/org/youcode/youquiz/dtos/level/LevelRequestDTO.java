package org.youcode.youquiz.dtos.level;

import org.youcode.youquiz.entities.Question;

import java.util.List;

public record LevelRequestDTO(
        String description,
        Integer minPoints,
        Integer maxPoints
) {
}
