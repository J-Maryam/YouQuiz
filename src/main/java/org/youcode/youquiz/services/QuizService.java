package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.quiz.QuizRequestDTO;
import org.youcode.youquiz.dtos.quiz.QuizResponseDTO;
import org.youcode.youquiz.entities.Quiz;

public interface QuizService extends GenericService<Quiz, Long, QuizRequestDTO, QuizResponseDTO> {
}
