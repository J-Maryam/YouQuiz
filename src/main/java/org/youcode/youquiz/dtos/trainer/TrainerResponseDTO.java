package org.youcode.youquiz.dtos.trainer;

import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;

import java.time.LocalDate;
import java.util.List;

public record TrainerResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String address,
        LocalDate birthDate,
        List<EmbeddableQuizDTO> quizzes
) {
}
