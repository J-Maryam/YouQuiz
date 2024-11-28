package org.youcode.youquiz.dtos.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record StudentRequestDTO(
        @NotBlank(message = "firstname")
        String firstName,
        @NotBlank(message = "last name")
        String lastName,
        @NotBlank(message = "address")
        String address,
        @NotNull
        @Past
        LocalDate birthDate,
        LocalDate registrationDate
) {
}
