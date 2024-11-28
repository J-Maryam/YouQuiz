package org.youcode.youquiz.dtos.quizQuestion;

import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;

public record QuizQuestionResponseDTO(
        int duration,
        EmbeddableQuizDTO quiz,
        EmbeddableQuestionDTO question
) {
}
