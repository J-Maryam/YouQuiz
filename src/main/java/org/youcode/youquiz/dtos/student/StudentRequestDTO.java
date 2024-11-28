package org.youcode.youquiz.dtos.student;

import org.youcode.youquiz.dtos.user.UserRequestDTO;

import java.time.LocalDate;

public record StudentRequestDTO(
        UserRequestDTO user,
        LocalDate registrationDate
) {
}
