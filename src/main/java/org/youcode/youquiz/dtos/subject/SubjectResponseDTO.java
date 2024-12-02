package org.youcode.youquiz.dtos.subject;

import org.youcode.youquiz.dtos.question.EmbeddableQuestionDTO;
import org.youcode.youquiz.dtos.quizSubject.EmbeddableQuizSubjectDTO;

import java.util.List;

public record SubjectResponseDTO(
        Long id,
        String title,
        EmbeddableSubjectDTO parentSubject,
        List<EmbeddableSubjectDTO> subSubjects,
        List<EmbeddableQuestionDTO> questions,
        List<EmbeddableQuizSubjectDTO> quizSubjects
) {
}
