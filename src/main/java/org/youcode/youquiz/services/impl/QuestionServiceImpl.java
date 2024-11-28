package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.question.QuestionRequestDTO;
import org.youcode.youquiz.dtos.question.QuestionResponseDTO;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.mappers.QuestionMapper;
import org.youcode.youquiz.repositories.LevelRepository;
import org.youcode.youquiz.repositories.QuestionRepository;
import org.youcode.youquiz.repositories.SubjectRepository;
import org.youcode.youquiz.services.QuestionService;

@Service
@Transactional
@Validated
public class QuestionServiceImpl extends GenericServiceImpl<Question, Long, QuestionRequestDTO, QuestionResponseDTO> implements QuestionService {

    private final SubjectRepository subjectRepository;
    private final LevelRepository levelRepository;
    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper, SubjectRepository subjectRepository, LevelRepository levelRepository) {
        super(repository, mapper);
        this.subjectRepository = subjectRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public QuestionResponseDTO create(QuestionRequestDTO requestDto) {
        Subject existingSubject = subjectRepository.findById(requestDto.subjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject with Id " + requestDto.subjectId() + " does not exist"));

        Level existingLevel = levelRepository.findById(requestDto.levelId())
                .orElseThrow(() -> new EntityNotFoundException("Level with Id " + requestDto.levelId() + " does not exist"));

        Question question = mapper.toEntity(requestDto);
        question.setSubject(existingSubject);
        question.setLevel(existingLevel);
        Question saved = repository.save(question);
        return mapper.toDto(saved);
    }
}
