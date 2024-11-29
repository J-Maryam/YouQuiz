package org.youcode.youquiz.dtos.questionHasAnswers;

public record QuestionHasAnswersRequestDTO(
        boolean isTrue,
        Long questionId,
        Long answerId
) {
}
