package org.youcode.youquiz.dtos.trainer;

import java.time.LocalDate;

public record EmbeddableTrainerDTO(
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate,
        String specialty
) {
}
