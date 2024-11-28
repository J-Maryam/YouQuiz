package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionRequestDTO;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionResponseDTO;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.mappers.QuizQuestionMapper;
import org.youcode.youquiz.repositories.QuizQuestionRepository;
import org.youcode.youquiz.services.QuizQuestionService;

@Service
@Transactional
@Validated
public class QuizQuestionServiceImpl extends GenericServiceImpl<QuizQuestion, Long, QuizQuestionRequestDTO, QuizQuestionResponseDTO> implements QuizQuestionService {
    public QuizQuestionServiceImpl(QuizQuestionRepository repository, QuizQuestionMapper mapper) {
        super(repository, mapper);
    }
}
