package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.services.QuizAssignmentService;

@RestController
@RequestMapping("/api/")
public class QuizAssignmentController extends GenericControllerImpl<QuizAssignment, QuizAssignmentId, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> {
    public QuizAssignmentController(QuizAssignmentService service) {
        super(service);
    }
}
