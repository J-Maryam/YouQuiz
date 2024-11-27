package org.youcode.youquiz.dtos.response;

import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.entities.enums.QuestionType;

import java.util.List;

public record QuestionResponseDTO(
        Long id,
        int numberOfAnswers,
        int numberOfCorrectAnswers,
        String text,
        QuestionType questionType,
        SubjectResponseDTO subject
//        Level level,
//        List<QuizQuestion> quizQuestions,
//        List<AnswerValidation> answerValidations
) {
}
