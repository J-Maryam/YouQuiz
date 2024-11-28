package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionRequestDTO;
import org.youcode.youquiz.dtos.quizQuestion.QuizQuestionResponseDTO;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.embbedableId.QuizQuestionId;
import org.youcode.youquiz.mappers.QuizQuestionMapper;
import org.youcode.youquiz.repositories.QuestionRepository;
import org.youcode.youquiz.repositories.QuizQuestionRepository;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.services.QuizQuestionService;

@Service
@Transactional
@Validated
public class QuizQuestionServiceImpl extends GenericServiceImpl<QuizQuestion, Long, QuizQuestionRequestDTO, QuizQuestionResponseDTO> implements QuizQuestionService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    public QuizQuestionServiceImpl(QuizQuestionRepository repository, QuizQuestionMapper mapper, QuizRepository quizRepository, QuestionRepository questionRepository) {
        super(repository, mapper);
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public QuizQuestionResponseDTO create(QuizQuestionRequestDTO requestDto) {
        Quiz existingQuiz = quizRepository.findById(requestDto.quizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz with Id: " + requestDto.quizId() + " not found"));

        Question existingQuestion = questionRepository.findById(requestDto.questionId())
                .orElseThrow(() -> new EntityNotFoundException("Question with Id: " + requestDto.questionId() + " not found"));

        QuizQuestionId quizQuestionId = new QuizQuestionId(existingQuiz.getId(), existingQuestion.getId());
        QuizQuestion quizQuestion = mapper.toEntity(requestDto);
        quizQuestion.setId(quizQuestionId);
        quizQuestion.setQuestion(existingQuestion);
        quizQuestion.setQuiz(existingQuiz);
        QuizQuestion saved = repository.save(quizQuestion);
        return mapper.toDto(saved);
    }
}
