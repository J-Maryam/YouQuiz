package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.answer.AnswerRequestDTO;
import org.youcode.youquiz.dtos.answer.AnswerResponseDTO;
import org.youcode.youquiz.entities.Answer;
import org.youcode.youquiz.mappers.AnswerMapper;
import org.youcode.youquiz.repositories.AnswerRepository;
import org.youcode.youquiz.services.AnswerService;

@Service
@Transactional
@Validated
public class AnswerServiceImpl extends GenericServiceImpl<Answer, Long, AnswerRequestDTO, AnswerResponseDTO> implements AnswerService {
    public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper) {
        super(repository, mapper);
    }
}
