package org.youcode.youquiz.dtos.user;

import java.time.LocalDate;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate
) {
}
