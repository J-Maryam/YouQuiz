package org.youcode.youquiz.dtos.student;

import org.youcode.youquiz.dtos.user.UserResponseDTO;

import java.time.LocalDate;

public record EmbeddableStudentDTO(
        UserResponseDTO user,
        LocalDate registrationDate
) {
}
