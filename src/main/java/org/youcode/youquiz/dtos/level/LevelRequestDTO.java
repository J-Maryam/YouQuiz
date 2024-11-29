package org.youcode.youquiz.dtos.level;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.youcode.youquiz.common.validation.annotation.UniqueValue;
import org.youcode.youquiz.entities.Level;

public record LevelRequestDTO(

        @NotBlank
        @UniqueValue(entityClass = Level.class, fieldName = "description", message = "Level must be unique")
        String description,
        @NotNull
        Integer minPoints,
        @NotNull
        Integer maxPoints
) {
}
