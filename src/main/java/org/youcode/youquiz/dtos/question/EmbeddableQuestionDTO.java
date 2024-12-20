package org.youcode.youquiz.dtos.question;

import org.youcode.youquiz.dtos.level.EmbeddableLevelDTO;
import org.youcode.youquiz.dtos.subject.EmbeddableSubjectDTO;
import org.youcode.youquiz.entities.enums.QuestionType;

public record EmbeddableQuestionDTO(
        Long id,
        int numberOfAnswers,
        int numberOfCorrectAnswers,
        String text,
        QuestionType questionType,
        EmbeddableSubjectDTO subject
//        EmbeddableLevelDTO level
) {
}
