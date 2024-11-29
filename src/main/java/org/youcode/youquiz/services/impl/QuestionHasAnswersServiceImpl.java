package org.youcode.youquiz.services.impl;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.Answer;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.entities.enums.QuestionType;
import org.youcode.youquiz.mappers.QuestionHasAnswersMapper;
import org.youcode.youquiz.repositories.AnswerRepository;
import org.youcode.youquiz.repositories.QuestionHasAnswersRepository;
import org.youcode.youquiz.repositories.QuestionRepository;
import org.youcode.youquiz.services.QuestionHasAnswersService;

@Service
@Transactional
@Validated
public class QuestionHasAnswersServiceImpl extends GenericServiceImpl<QuestionHasAnswers, QuestionHasAnswersId, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> implements QuestionHasAnswersService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final QuestionHasAnswersRepository hasAnswersRepository;
    public QuestionHasAnswersServiceImpl(QuestionHasAnswersRepository repository, QuestionHasAnswersMapper mapper, QuestionRepository questionRepository, AnswerRepository answerRepository, QuestionHasAnswersRepository hasAnswersRepository) {
        super(repository, mapper);
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.hasAnswersRepository = hasAnswersRepository;
    }

    @Override
    public QuestionHasAnswersResponseDTO create(QuestionHasAnswersRequestDTO requestDto) {
        Question existingQuestion = questionRepository.findById(requestDto.questionId())
                .orElseThrow(() -> new EntityNotFoundException("Question with Id " + requestDto.questionId() + " does not exist"));

        Answer existingAnswer = answerRepository.findById(requestDto.answerId())
                .orElseThrow(() -> new EntityNotFoundException("Answer with Id " + requestDto.answerId() + " does not exist"));

        validateQuestionAnswers(existingQuestion, requestDto.correct());

        QuestionHasAnswersId id = new QuestionHasAnswersId(existingQuestion.getId(), existingAnswer.getId());
        QuestionHasAnswers entity = mapper.toEntity(requestDto);
        entity.setId(id);
        entity.setQuestion(existingQuestion);
        entity.setAnswer(existingAnswer);
        QuestionHasAnswers saved = repository.save(entity);
        return mapper.toDto(saved);
    }

//    TODO: implements the other methods
    private void validateQuestionAnswers(Question question, boolean correct) {
        long currentAnswerCount = hasAnswersRepository.countByQuestionId(question.getId());

        if (currentAnswerCount >= question.getNumberOfAnswers()) {
            throw new IllegalArgumentException("The total number of answers for the question has been reached.");
        }

        if (question.getQuestionType() == QuestionType.SINGLE_CHOICE) {
            long correctAnswerCount = hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true);
            if (correct && correctAnswerCount >= 1) {
                throw new IllegalArgumentException("Only one correct answer is allowed for SINGLE_CHOICE questions.");
            }
        } else if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
            long correctAnswerCount = hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true);
            if (correct && correctAnswerCount >= question.getNumberOfCorrectAnswers()) {
                throw new IllegalArgumentException("The number of correct answers for the question has been reached.");
            }
        }
    }

}
