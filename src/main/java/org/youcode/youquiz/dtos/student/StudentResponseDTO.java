package org.youcode.youquiz.dtos.student;

import org.youcode.youquiz.dtos.quizAssignment.EmbeddableQuizAssignmentDTO;

import java.time.LocalDate;
import java.util.List;

public record StudentResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate,
        LocalDate registrationDate,
        List<EmbeddableQuizAssignmentDTO> quizAssignments
) {
}
