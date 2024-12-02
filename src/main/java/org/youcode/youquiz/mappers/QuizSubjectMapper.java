package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectRequestDTO;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectResponseDTO;
import org.youcode.youquiz.entities.QuizSubject;

@Mapper(componentModel = "spring")
public interface QuizSubjectMapper extends GenericMapper<QuizSubject, QuizSubjectRequestDTO, QuizSubjectResponseDTO> {
}
