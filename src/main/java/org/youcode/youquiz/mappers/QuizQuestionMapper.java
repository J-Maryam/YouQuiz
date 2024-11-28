package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionRequestDTO;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionResponseDTO;
import org.youcode.youquiz.entities.QuizQuestion;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper extends GenericMapper<QuizQuestion, QuizQuestionRequestDTO, QuizQuestionResponseDTO> {
}
