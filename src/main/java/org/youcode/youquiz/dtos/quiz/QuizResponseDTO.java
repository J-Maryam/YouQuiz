package org.youcode.youquiz.dtos.quiz;

import org.youcode.youquiz.dtos.trainer.EmbeddableTrainerDTO;
import org.youcode.youquiz.dtos.trainer.TrainerResponseDTO;
import org.youcode.youquiz.entities.Trainer;

public record QuizResponseDTO(
        Long id,
        String title,
        double successScore,
        boolean canSeeAnswers,
        boolean canSeeResult,
        Integer numberOfAttempts,
        String remark,
        EmbeddableTrainerDTO trainer
) {
}
