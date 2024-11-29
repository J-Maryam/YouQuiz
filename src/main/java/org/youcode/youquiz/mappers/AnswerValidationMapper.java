package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.entities.AnswerValidation;

@Mapper(componentModel = "spring")
public interface AnswerValidationMapper extends GenericMapper<AnswerValidation, AnswerValidationRequestDTO, AnswerValidationResponseDTO> {
}
