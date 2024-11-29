package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.answer.AnswerRequestDTO;
import org.youcode.youquiz.dtos.answer.AnswerResponseDTO;
import org.youcode.youquiz.entities.Answer;

public interface AnswerService extends GenericService<Answer, Long, AnswerRequestDTO, AnswerResponseDTO> {
}
