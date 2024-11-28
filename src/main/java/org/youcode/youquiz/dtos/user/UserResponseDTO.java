package org.youcode.youquiz.dtos.user;

import java.time.LocalDate;

public record UserResponseDTO(
        Long id,
        String firstname,
        String lastname,
        String address,
        LocalDate birthDate
) {
}
