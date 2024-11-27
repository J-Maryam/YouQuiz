package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.question.QuestionRequestDTO;
import org.youcode.youquiz.dtos.question.QuestionResponseDTO;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.mappers.QuestionMapper;
import org.youcode.youquiz.repositories.QuestionRepository;
import org.youcode.youquiz.services.QuestionService;

@Service
@Transactional
@Validated
public class QuestionServiceImpl extends GenericServiceImpl<Question, Long, QuestionRequestDTO, QuestionResponseDTO> implements QuestionService {
    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper) {
        super(repository, mapper);
    }
}
