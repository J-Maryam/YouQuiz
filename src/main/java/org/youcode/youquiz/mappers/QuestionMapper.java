package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.request.QuestionRequestDTO;
import org.youcode.youquiz.dtos.response.QuestionResponseDTO;
import org.youcode.youquiz.entities.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends GenericMapper<Question, QuestionRequestDTO, QuestionResponseDTO> {
}
