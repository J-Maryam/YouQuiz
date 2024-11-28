package org.youcode.youquiz.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.ApiResponse;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.services.QuizAssignmentService;

@RestController
@RequestMapping("/api/quiz_assignments")
public class QuizAssignmentController extends GenericControllerImpl<QuizAssignment, QuizAssignmentId, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> {
    public QuizAssignmentController(QuizAssignmentService service) {
        super(service);
    }

    @PostMapping("/quizzes/{quiz_id}")
    public ResponseEntity<ApiResponse<QuizAssignmentResponseDTO>> create(@RequestBody @Valid QuizAssignmentRequestDTO request) {
        QuizAssignmentResponseDTO responseDTO = service.create(request);
        return ResponseEntity.ok(ApiResponse.success(responseDTO, "Item created successfully"));
    }
}
