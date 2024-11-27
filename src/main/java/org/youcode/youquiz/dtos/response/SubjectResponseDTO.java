package org.youcode.youquiz.dtos.response;

import org.youcode.youquiz.dtos.EmbeddableDTO.EmbeddableSubjectResponseDTO;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.QuizSubject;

import java.util.List;

public record SubjectResponseDTO(
        Long id,
        String title,
        EmbeddableSubjectResponseDTO parentSubject,
        List<EmbeddableSubjectResponseDTO> subSubject,
        List<Question> questions,
        List<QuizSubject> quizSubjects
) {
}
