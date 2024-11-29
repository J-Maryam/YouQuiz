package org.youcode.youquiz.dtos.questionHasAnswers;

public record QuestionHasAnswersRequestDTO(
        boolean correct,
        Long questionId,
        Long answerId
) {
}
