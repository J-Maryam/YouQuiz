package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectRequestDTO;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectResponseDTO;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.embbedableId.QuizSubjectId;

public interface QuizSubjectService extends GenericService<QuizSubject, QuizSubjectId, QuizSubjectRequestDTO, QuizSubjectResponseDTO> {
}
