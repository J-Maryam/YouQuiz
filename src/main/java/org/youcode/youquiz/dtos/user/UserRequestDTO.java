package org.youcode.youquiz.dtos.user;

import java.time.LocalDate;

public record UserRequestDTO(
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate
) {
}
