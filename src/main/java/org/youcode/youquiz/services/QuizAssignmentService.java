package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;

public interface QuizAssignmentService extends GenericService<QuizAssignment, QuizAssignmentId, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> {
}
