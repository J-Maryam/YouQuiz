package org.youcode.youquiz.dtos.quiz;

import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.Trainer;

import java.util.List;

public record EmbeddableQuizDTO(
        Long id,
        String title,
        double successScore,
        boolean canSeeAnswers,
        boolean canSeeResult,
        Integer numberOfAttempts,
        String remark,
        Trainer trainer,
        List<QuizAssignment> quizAssignments,
        List<QuizQuestion> quizQuestions,
        List<QuizSubject> quizSubjects
) {
}
