package org.youcode.youquiz.dtos.student;

import org.youcode.youquiz.dtos.quizAssignment.EmbeddableQuizAssignmentDTO;
import org.youcode.youquiz.dtos.user.UserResponseDTO;

import java.time.LocalDate;
import java.util.List;

public record StudentResponseDTO(
        UserResponseDTO user,
        LocalDate registrationDate,
        List<EmbeddableQuizAssignmentDTO> quizAssignments
) {
}
