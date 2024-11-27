package org.youcode.youquiz.dtos.EmbeddableDTO;

import org.youcode.youquiz.dtos.response.SubjectResponseDTO;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.enums.QuestionType;

public record EmbeddableQuestionDTO(
        Long id,
        int numberOfAnswers,
        int numberOfCorrectAnswers,
        String text,
        QuestionType questionType,
        SubjectResponseDTO subject
//        Level level
) {
}
