package org.youcode.youquiz.services.impl;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityCreationException;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.question.QuestionRequestDTO;
import org.youcode.youquiz.dtos.question.QuestionResponseDTO;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.entities.enums.QuestionType;
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
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper, SubjectRepository subjectRepository, LevelRepository levelRepository, QuestionRepository questionRepository) {
        super(repository, mapper);
        this.subjectRepository = subjectRepository;
        this.levelRepository = levelRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionResponseDTO create(QuestionRequestDTO requestDto) {
        Subject existingSubject = subjectRepository.findById(requestDto.subjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject with Id " + requestDto.subjectId() + " does not exist"));

        if (!existingSubject.getSubSubjects().isEmpty()) {
            throw new EntityCreationException("Cannot create question in a parent subject, try to create question in subSubject");
        }

        if (requestDto.questionType() == QuestionType.SINGLE_CHOICE && requestDto.numberOfCorrectAnswers() > 1) {
            throw new EntityCreationException("Cannot create more than one correct answer in the single choice question");
        }

        Level existingLevel = levelRepository.findById(requestDto.levelId())
                .orElseThrow(() -> new EntityNotFoundException("Level with Id " + requestDto.levelId() + " does not exist"));

        validateQuestionAnswers(requestDto.numberOfAnswers(), requestDto.numberOfCorrectAnswers(), requestDto.text(), requestDto.subjectId());

        Question question = mapper.toEntity(requestDto);
        question.setSubject(existingSubject);
        question.setLevel(existingLevel);
        Question saved = repository.save(question);
        return mapper.toDto(saved);
    }

    private void validateQuestionAnswers(int numberOfAnswers, int numberOfCorrectAnswers, String text, Long subjectId) {
        if (numberOfAnswers <= 0) {
            throw new IllegalArgumentException("The number of answers must be greater than 0");
        }

        if (numberOfCorrectAnswers < 1 || numberOfCorrectAnswers > numberOfAnswers) {
            throw new IllegalArgumentException(
                    "The number of correct answers must be between 1 and the total number of answers (" + numberOfAnswers + ")"
            );
        }

        boolean questionExists = questionRepository.existsByTextAndSubjectId(text, subjectId);

        if (questionExists) {
            throw new EntityExistsException("Question with this same text " + text + " already exists");
        }
    }

}
