package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionRequestDTO;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionResponseDTO;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.services.QuizQuestionService;

@RestController
@RequestMapping("/api/quiz_questions")
public class QuizQuestionController extends GenericControllerImpl<QuizQuestion, Long, QuizQuestionRequestDTO, QuizQuestionResponseDTO> {
    public QuizQuestionController(QuizQuestionService service) {
        super(service);
    }
}
