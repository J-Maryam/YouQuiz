package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.answer.AnswerRequestDTO;
import org.youcode.youquiz.dtos.answer.AnswerResponseDTO;
import org.youcode.youquiz.entities.Answer;
import org.youcode.youquiz.services.AnswerService;

@RestController
@RequestMapping("/api/answers")
public class AnswerController extends GenericControllerImpl<Answer, Long, AnswerRequestDTO, AnswerResponseDTO> {
    public AnswerController(AnswerService service) {
        super(service);
    }
}
