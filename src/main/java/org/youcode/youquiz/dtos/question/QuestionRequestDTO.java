package org.youcode.youquiz.dtos.question;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
        Long subjectId,

        Long levelId
) {
}
