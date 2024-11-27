package org.youcode.youquiz.dtos.question;

import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
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
