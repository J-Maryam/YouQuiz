package org.youcode.youquiz.dtos.quizQuestion;

public record QuizQuestionRequestDTO(
        int timer,
        Long quizId,
        Long questionId
) {
}
