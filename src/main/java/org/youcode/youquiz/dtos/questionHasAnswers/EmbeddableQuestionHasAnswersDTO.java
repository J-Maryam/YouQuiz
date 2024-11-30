package org.youcode.youquiz.dtos.questionHasAnswers;

import org.youcode.youquiz.dtos.answer.EmbeddableAnswerDTO;
import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;

public record EmbeddableQuestionHasAnswersDTO(
        boolean correct,
        double note,
        EmbeddableQuestionDTO question,
        EmbeddableAnswerDTO answer
) {
}
