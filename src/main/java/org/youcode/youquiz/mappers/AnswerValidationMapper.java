package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.dtos.answerValidation.EmbeddableAnswerValidationDTO;
import org.youcode.youquiz.entities.AnswerValidation;

@Mapper(componentModel = "spring", uses = {QuizMapper.class, StudentMapper.class, QuestionMapper.class, AnswerMapper.class})
public interface AnswerValidationMapper extends GenericMapper<AnswerValidation, AnswerValidationRequestDTO, AnswerValidationResponseDTO> {

    @Mapping(source = "quiz", target = "quiz")
    @Mapping(source = "student", target = "student")
//    @Mapping(source = "answer", target = "answer")
    @Mapping(source = "question", target = "question")
    EmbeddableAnswerValidationDTO toEmbeddableAnswerValidationDTO(AnswerValidation answerValidation);

}