package org.youcode.youquiz.dtos.trainer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record TrainerRequestDTO(
        @NotBlank(message = "firstname")
        String firstName,
        @NotBlank(message = "last name")
        String lastName,
        @NotBlank(message = "address")
        String address,
        @NotNull
        @Past
        LocalDate birthDate,
        @NotBlank(message = "speciality")
        String specialty
) {
}
