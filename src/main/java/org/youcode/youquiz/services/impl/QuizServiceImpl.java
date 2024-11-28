package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quiz.QuizRequestDTO;
import org.youcode.youquiz.dtos.quiz.QuizResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.mappers.QuizMapper;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.services.QuizService;

@Service
@Validated
@Transactional
public class QuizServiceImpl extends GenericServiceImpl<Quiz, Long, QuizRequestDTO, QuizResponseDTO> implements QuizService {
    public QuizServiceImpl(QuizRepository repository, QuizMapper mapper) {
        super(repository, mapper);
    }
}
