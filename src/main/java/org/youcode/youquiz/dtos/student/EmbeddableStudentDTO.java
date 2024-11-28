package org.youcode.youquiz.dtos.student;

import java.time.LocalDate;

public record EmbeddableStudentDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate,
        LocalDate registrationDate
) {
}
