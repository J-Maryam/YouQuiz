package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.mappers.QuestionHasAnswersMapper;
import org.youcode.youquiz.repositories.QuestionHasAnswersRepository;
import org.youcode.youquiz.services.QuestionHasAnswersService;

@Service
@Transactional
@Validated
public class QuestionHasAnswersServiceImpl extends GenericServiceImpl<QuestionHasAnswers, QuestionHasAnswersId, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> implements QuestionHasAnswersService {
    public QuestionHasAnswersServiceImpl(QuestionHasAnswersRepository repository, QuestionHasAnswersMapper mapper) {
        super(repository, mapper);
    }
}
