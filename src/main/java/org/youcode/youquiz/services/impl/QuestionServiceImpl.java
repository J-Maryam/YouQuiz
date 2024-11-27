package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.request.QuestionRequestDTO;
import org.youcode.youquiz.dtos.response.QuestionResponseDTO;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.mappers.QuestionMapper;
import org.youcode.youquiz.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl extends GenericServiceImpl<Question, Long, QuestionRequestDTO, QuestionResponseDTO> {
    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper) {
        super(repository, mapper);
    }
}
