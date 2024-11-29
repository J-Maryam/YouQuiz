package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;

public interface QuestionHasAnswersService extends GenericService<QuestionHasAnswers, QuestionHasAnswersId, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> {
}
