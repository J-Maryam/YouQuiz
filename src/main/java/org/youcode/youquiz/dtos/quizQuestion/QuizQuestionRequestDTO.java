package org.youcode.youquiz.dtos.quizQuestion;

public record QuizQuestionRequestDTO(
        int duration,
        Long quizId,
        Long questionId
) {
}
