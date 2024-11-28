package org.youcode.youquiz.dtos.trainer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.youcode.youquiz.dtos.user.UserRequestDTO;

import java.time.LocalDate;

public record TrainerRequestDTO(
        UserRequestDTO user,
        String specialty
) {
}
