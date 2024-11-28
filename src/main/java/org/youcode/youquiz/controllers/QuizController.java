package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quiz.QuizRequestDTO;
import org.youcode.youquiz.dtos.quiz.QuizResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.services.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController extends GenericControllerImpl<Quiz, Long, QuizRequestDTO, QuizResponseDTO> {
    public QuizController(QuizService service) {
        super(service);
    }
}
