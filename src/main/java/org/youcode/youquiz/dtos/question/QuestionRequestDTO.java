package org.youcode.youquiz.dtos.question;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.youcode.youquiz.common.validation.annotation.Exists;
import org.youcode.youquiz.common.validation.annotation.UniqueValue;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.entities.enums.QuestionType;

public record QuestionRequestDTO(

        @NotNull
        int numberOfAnswers,

        @NotNull
        int numberOfCorrectAnswers,

        @NotBlank
        @UniqueValue(entityClass = Question.class, fieldName = "text", message = "Question must be unique")
        String text,

        @NotNull
        @Enumerated(EnumType.STRING)
        QuestionType questionType,

        @NotNull
        @Exists(entityClass = Subject.class, message = "Subject id does not exist")
        Long subjectId,

        @NotNull
        @Exists(entityClass = Level.class, message = "Level id does not exist")
        Long levelId
) {
}
