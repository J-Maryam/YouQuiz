package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.mappers.QuizAssignmentMapper;
import org.youcode.youquiz.repositories.QuizAssignmentRepository;
import org.youcode.youquiz.services.QuizAssignmentService;

@Service
@Transactional
@Validated
public class QuizAssignmentServiceImpl extends GenericServiceImpl<QuizAssignment, QuizAssignmentId, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> implements QuizAssignmentService {
    public QuizAssignmentServiceImpl(QuizAssignmentRepository repository, QuizAssignmentMapper mapper) {
        super(repository, mapper);
    }
}
