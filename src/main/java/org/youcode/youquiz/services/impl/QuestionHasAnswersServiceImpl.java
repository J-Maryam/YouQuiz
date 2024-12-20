package org.youcode.youquiz.services.impl;

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

import java.util.List;

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

        validateQuestionAnswers(existingQuestion, requestDto.correct(), requestDto.note());

        QuestionHasAnswersId id = new QuestionHasAnswersId(existingQuestion.getId(), existingAnswer.getId());
        QuestionHasAnswers entity = mapper.toEntity(requestDto);
        entity.setId(id);
        entity.setQuestion(existingQuestion);
        entity.setAnswer(existingAnswer);
        QuestionHasAnswers saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<QuestionHasAnswersResponseDTO> getByQuestionId(Long questionId) {
        if (!questionRepository.existsById(questionId)) {
            throw new EntityNotFoundException("Question with Id " + questionId + " does not exist");
        }

        List<QuestionHasAnswers> questionHasAnswers = hasAnswersRepository.findAllByQuestionId(questionId);

        return questionHasAnswers.stream()
                .map(mapper::toDto)
                .toList();
    }

    private void validateQuestionAnswers(Question question, boolean correct, double note) {
        long currentAnswerCount = hasAnswersRepository.countByQuestionId(question.getId());
        if (currentAnswerCount >= question.getNumberOfAnswers()) {
            throw new IllegalArgumentException("The total number of answers for the question has been reached.");
        }

        if (!correct) {
            if (note != 0) {
                throw new IllegalArgumentException("If the answer is incorrect, the note must be 0.");
            }
            return;
        }

        if (note <= 0) {
            throw new IllegalArgumentException("The note must be greater than 0 for correct answers.");
        }

        if (question.getQuestionType() == QuestionType.SINGLE_CHOICE) {
            long correctAnswerCount = hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true);
            if (correctAnswerCount >= 1) {
                throw new IllegalArgumentException("Only one correct answer is allowed for SINGLE_CHOICE questions.");
            }
        } else if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
            long correctAnswerCount = hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true);
            if (correctAnswerCount >= question.getNumberOfCorrectAnswers()) {
                throw new IllegalArgumentException("The number of correct answers for the question has been reached.");
            }
        }

        double minNote = question.getLevel().getMinPoints();
        double maxNote = question.getLevel().getMaxPoints();

        if (note > maxNote) {
            throw new IllegalArgumentException(
//                    "The note must be between " + minNote + " and " + maxNote + " for the question level: " + question.getLevel().getDescription()
                    "The entered point exceeds the maximum allowed points (" + maxNote + "). Please provide a point within the valid range."
            );
        }


        Double totalNotes = hasAnswersRepository.sumNoteByQuestionId(question.getId());
        if (totalNotes + note > maxNote) {
            throw new IllegalArgumentException("The total note for all answers of the question cannot exceed " + maxNote + ".");
        }
    }

}
