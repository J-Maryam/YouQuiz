package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;
import org.youcode.youquiz.mappers.AnswerValidationMapper;
import org.youcode.youquiz.repositories.AnswerRepository;
import org.youcode.youquiz.repositories.AnswerValidationRepository;
import org.youcode.youquiz.repositories.QuestionRepository;
import org.youcode.youquiz.services.AnswerValidationService;

@Service
@Transactional
@Validated
public class AnswerValidationServiceImpl extends GenericServiceImpl<AnswerValidation, AnswerValidationId, AnswerValidationRequestDTO, AnswerValidationResponseDTO> implements AnswerValidationService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public AnswerValidationServiceImpl(AnswerValidationRepository repository, AnswerValidationMapper mapper, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        super(repository, mapper);
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }
}
