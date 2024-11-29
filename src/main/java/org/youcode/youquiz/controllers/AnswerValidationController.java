package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationRequestDTO;
import org.youcode.youquiz.dtos.answerValidation.AnswerValidationResponseDTO;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;
import org.youcode.youquiz.services.AnswerValidationService;

@RestController
@RequestMapping("/api/answer_validations")
public class AnswerValidationController extends GenericControllerImpl<AnswerValidation, AnswerValidationId, AnswerValidationRequestDTO, AnswerValidationResponseDTO> {
    public AnswerValidationController(AnswerValidationService service) {
        super(service);
    }
}
