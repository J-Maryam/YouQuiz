package org.youcode.youquiz.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UserRequestDTO(
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @NotBlank
        String address,
        @NotNull
        @Past
        LocalDate birthDate
) {
}
