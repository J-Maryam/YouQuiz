package org.youcode.youquiz.dtos.quiz;

import org.youcode.youquiz.entities.Trainer;

public record QuizRequestDTO(
        String title,
        double successScore,
        boolean canSeeAnswers,
        boolean canSeeResult,
        Integer numberOfAttempts,
        String remark,
        Trainer trainer
) {
}
