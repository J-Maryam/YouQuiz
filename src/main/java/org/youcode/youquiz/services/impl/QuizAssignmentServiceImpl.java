package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentRequestDTO;
import org.youcode.youquiz.dtos.quizAssignment.QuizAssignmentResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.Student;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;
import org.youcode.youquiz.entities.enums.ResultType;
import org.youcode.youquiz.mappers.QuizAssignmentMapper;
import org.youcode.youquiz.repositories.QuizAssignmentRepository;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.repositories.StudentRepository;
import org.youcode.youquiz.services.QuizAssignmentService;

@Service
@Transactional
@Validated
public class QuizAssignmentServiceImpl extends GenericServiceImpl<QuizAssignment, QuizAssignmentId, QuizAssignmentRequestDTO, QuizAssignmentResponseDTO> implements QuizAssignmentService {

    private final StudentRepository studentRepository;
    private final QuizRepository quizRepository;
    public QuizAssignmentServiceImpl(QuizAssignmentRepository repository, QuizAssignmentMapper mapper, StudentRepository studentRepository, QuizRepository quizRepository) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizAssignmentResponseDTO create(QuizAssignmentRequestDTO requestDTO) {
        Student existingStudent = studentRepository.findById(requestDTO.studentId())
                .orElseThrow(() -> new EntityNotFoundException("Student with Id " + requestDTO.studentId() + " not found"));

        Quiz existingQuiz = quizRepository.findById(requestDTO.quizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz with Id " + requestDTO.quizId() + " not found"));

        QuizAssignmentId quizAssignmentId = new QuizAssignmentId(existingStudent.getId(), existingQuiz.getId());
        QuizAssignment quizAssignment = mapper.toEntity(requestDTO);
        quizAssignment.setId(quizAssignmentId);
        quizAssignment.setQuiz(existingQuiz);
        quizAssignment.setStudent(existingStudent);
        quizAssignment.setResult((ResultType.PENDING).toString());
        quizAssignment.setAttempt(0);

        QuizAssignment saved = repository.save(quizAssignment);
        return mapper.toDto(saved);
    }
}
