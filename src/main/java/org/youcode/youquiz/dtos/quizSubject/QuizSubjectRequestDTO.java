package org.youcode.youquiz.dtos.quizSubject;

import jakarta.validation.constraints.NotNull;

public record QuizSubjectRequestDTO(
        @NotNull
        Long quizId,
        @NotNull
        Long subjectId
) {
}
