package org.youcode.youquiz.dtos.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.entities.enums.QuestionType;

public record QuestionRequestDTO(

        @NotNull
        int numberOfAnswers,

        @NotNull
        int numberOfCorrectAnswers,

        @NotBlank
        String text,

        @NotNull
        @Enumerated(EnumType.STRING)
        QuestionType questionType,

        @NotNull
        Subject subject,

        Level level
) {
}
