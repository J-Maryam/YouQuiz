package org.youcode.youquiz.dtos.quizQuestion;

import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.Trainer;

import java.util.List;

public record EmbeddableQuizQuestionDTO(
        int timer,
        EmbeddableQuizDTO quiz,
        EmbeddableQuestionDTO question
) {
}
