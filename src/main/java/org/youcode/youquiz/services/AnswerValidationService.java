package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;

public interface AnswerValidationService extends GenericService<AnswerValidation, AnswerValidationId, AnswerValidationRequestDTO, AnswerValidationResponseDTO> {
}
