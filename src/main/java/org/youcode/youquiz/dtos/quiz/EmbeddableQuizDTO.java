package org.youcode.youquiz.dtos.quiz;

import org.youcode.youquiz.dtos.trainer.EmbeddableTrainerDTO;

public record EmbeddableQuizDTO(
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
