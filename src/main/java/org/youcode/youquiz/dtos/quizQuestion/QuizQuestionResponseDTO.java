package org.youcode.youquiz.dtos.quizQuestion;

import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;

public record QuizQuestionResponseDTO(
        int timer,
        EmbeddableQuizDTO quiz,
        EmbeddableQuestionDTO question
) {
}
