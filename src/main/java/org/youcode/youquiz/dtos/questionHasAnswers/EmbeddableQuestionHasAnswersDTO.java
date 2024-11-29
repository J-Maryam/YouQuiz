package org.youcode.youquiz.dtos.questionHasAnswers;

import org.youcode.youquiz.dtos.answer.EmbeddableAnswerDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;

public record EmbeddableQuestionHasAnswersDTO(
        boolean correct,
        EmbeddableQuestionDTO question,
        EmbeddableAnswerDTO answer
) {
}
