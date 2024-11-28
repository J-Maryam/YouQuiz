package org.youcode.youquiz.dtos.question;

import org.youcode.youquiz.dtos.answerValidation.EmbeddableAnswerValidationDTO;
import org.youcode.youquiz.dtos.level.EmbeddableLevelDTO;
import org.youcode.youquiz.dtos.quizQuestion.EmbeddableQuizQuestionDTO;
import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
import org.youcode.youquiz.entities.enums.QuestionType;

import java.util.List;

public record QuestionResponseDTO(
        Long id,
        int numberOfAnswers,
        int numberOfCorrectAnswers,
        String text,
        QuestionType questionType,
        SubjectResponseDTO subject,
        EmbeddableLevelDTO level,
        List<EmbeddableQuizQuestionDTO> quizQuestions,
        List<EmbeddableAnswerValidationDTO> answerValidations
) {
}
