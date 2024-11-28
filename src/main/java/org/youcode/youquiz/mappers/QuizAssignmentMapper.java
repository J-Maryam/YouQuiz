package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.QuizAssignment;

@Mapper(componentModel = "spring")
public interface QuizAssignmentMapper extends GenericMapper<QuizAssignment, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> {
}
