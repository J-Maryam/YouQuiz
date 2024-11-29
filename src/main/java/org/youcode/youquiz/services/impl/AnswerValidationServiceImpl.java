package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;
import org.youcode.youquiz.mappers.AnswerValidationMapper;
import org.youcode.youquiz.repositories.AnswerValidationRepository;
import org.youcode.youquiz.services.AnswerValidationService;

@Service
public class AnswerValidationServiceImpl extends GenericServiceImpl<AnswerValidation, AnswerValidationId, AnswerValidationRequestDTO, AnswerValidationResponseDTO> implements AnswerValidationService {
    public AnswerValidationServiceImpl(AnswerValidationRepository repository, AnswerValidationMapper mapper) {
        super(repository, mapper);
    }
}
