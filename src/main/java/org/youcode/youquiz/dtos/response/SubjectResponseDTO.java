package org.youcode.youquiz.dtos.response;

import org.youcode.youquiz.dtos.EmbeddableDTO.EmbeddableSubjectDTO;

public record SubjectResponseDTO(
        Long id,
        String title,
        EmbeddableSubjectDTO parentSubject
//        List<EmbeddableSubjectResponseDTO> subSubject,
//        List<Question> questions,
//        List<QuizSubject> quizSubjects
) {
}
