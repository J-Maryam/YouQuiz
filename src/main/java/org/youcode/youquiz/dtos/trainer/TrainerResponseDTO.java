package org.youcode.youquiz.dtos.trainer;

import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.dtos.user.UserResponseDTO;

import java.util.List;

public record TrainerResponseDTO(
        UserResponseDTO user,
        List<EmbeddableQuizDTO> quizzes
) {
}
