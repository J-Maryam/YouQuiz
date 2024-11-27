package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.request.QuestionRequestDTO;
import org.youcode.youquiz.dtos.response.QuestionResponseDTO;
import org.youcode.youquiz.entities.Question;

public interface QuestionService extends GenericService<Question, Long, QuestionRequestDTO, QuestionResponseDTO> {
}
