package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.question.QuestionRequestDTO;
import org.youcode.youquiz.dtos.question.QuestionResponseDTO;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.services.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController extends GenericControllerImpl<Question, Long, QuestionRequestDTO, QuestionResponseDTO> {
    public QuestionController(QuestionService service) {
        super(service);
    }
}
