package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.services.QuestionHasAnswersService;

@RestController
@RequestMapping("/api/question_has_answers")
public class QuestionHasAnswersController extends GenericControllerImpl<QuestionHasAnswers, QuestionHasAnswersId, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> {
    public QuestionHasAnswersController(QuestionHasAnswersService service) {
        super(service);
    }
}
