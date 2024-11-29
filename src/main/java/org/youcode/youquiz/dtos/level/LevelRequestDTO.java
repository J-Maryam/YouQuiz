package org.youcode.youquiz.dtos.level;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.youcode.youquiz.common.validation.annotation.UniqueValue;
import org.youcode.youquiz.entities.Level;

public record LevelRequestDTO(

        @NotBlank(message = "Description cannot be blank")
        @UniqueValue(entityClass = Level.class, fieldName = "description", message = "Level description must be unique")
        String description,

        @NotNull(message = "Minimum points cannot be null")
        Integer minPoints,

        @NotNull(message = "Maximum points cannot be null")
        Integer maxPoints
) {
}
