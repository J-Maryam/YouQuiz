package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectRequestDTO;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.entities.embbedableId.QuizSubjectId;
import org.youcode.youquiz.mappers.QuizSubjectMapper;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.repositories.QuizSubjectRepository;
import org.youcode.youquiz.repositories.SubjectRepository;
import org.youcode.youquiz.services.QuizSubjectService;

import java.util.List;

@Service
@Transactional
@Validated
public class QuizSubjectServiceImpl extends GenericServiceImpl<QuizSubject, QuizSubjectId, QuizSubjectRequestDTO, QuizSubjectResponseDTO> implements QuizSubjectService {

    private final QuizRepository quizRepository;
    private final SubjectRepository subjectRepository;
    private final QuizSubjectRepository quizSubjectRepository;

    public QuizSubjectServiceImpl(QuizSubjectRepository repository, QuizSubjectMapper mapper, QuizRepository quizRepository, SubjectRepository subjectRepository, QuizSubjectRepository quizSubjectRepository) {
        super(repository, mapper);
        this.quizRepository = quizRepository;
        this.subjectRepository = subjectRepository;
        this.quizSubjectRepository = quizSubjectRepository;
    }

    @Override
    public QuizSubjectResponseDTO create (QuizSubjectRequestDTO requestDTO) {
        Quiz quiz = quizRepository.findById(requestDTO.quizId())
                .orElseThrow(() -> new RuntimeException("Quiz with Id " + requestDTO.quizId() + " not found"));

        Subject subject = subjectRepository.findById(requestDTO.subjectId())
                .orElseThrow(() -> new RuntimeException("Subject with Id " + requestDTO.subjectId() + " not found"));

        QuizSubject quizSubject = mapper.toEntity(requestDTO);
        quizSubject.setQuiz(quiz);
        quizSubject.setSubject(subject);

        QuizSubject saved = repository.save(quizSubject);
        return mapper.toDto(saved);
    }

    @Override
    public List<QuizSubjectResponseDTO> getByQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz with Id " + quizId + " not found"));

        List<QuizSubject> quizSubjects = quizSubjectRepository.findAllByQuizId(quizId);

        return quizSubjects.stream()
                .map(mapper::toDto)
                .toList();
    }
}
