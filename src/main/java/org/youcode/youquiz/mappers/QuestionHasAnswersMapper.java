package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.QuestionHasAnswers;

@Mapper(componentModel = "spring")
public interface QuestionHasAnswersMapper extends GenericMapper<QuestionHasAnswers, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> {
}
