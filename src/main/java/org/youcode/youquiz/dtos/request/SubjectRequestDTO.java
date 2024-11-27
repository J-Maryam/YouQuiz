package org.youcode.youquiz.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record SubjectRequestDTO(

        @NotBlank
        String title,

        Long parentSubject
) {
}
