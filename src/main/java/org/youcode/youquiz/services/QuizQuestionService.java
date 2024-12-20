package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionRequestDTO;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionResponseDTO;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.embbedableId.QuizQuestionId;

public interface QuizQuestionService extends GenericService<QuizQuestion, QuizQuestionId, QuizQuestionRequestDTO, QuizQuestionResponseDTO> {
}
