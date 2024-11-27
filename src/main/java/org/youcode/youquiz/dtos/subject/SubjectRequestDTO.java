package org.youcode.youquiz.dtos.subject;

import jakarta.validation.constraints.NotBlank;

public record SubjectRequestDTO(

        @NotBlank
        String title,

        Long parentSubjectId
) {
}
