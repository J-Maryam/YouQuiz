package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.answer.AnswerRequestDTO;
import org.youcode.youquiz.dtos.answer.AnswerResponseDTO;
import org.youcode.youquiz.entities.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends GenericMapper<Answer, AnswerRequestDTO, AnswerResponseDTO> {
}
