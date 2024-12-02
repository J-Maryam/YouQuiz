package org.youcode.youquiz.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.Answer;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.entities.Question;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.entities.enums.LevelType;
import org.youcode.youquiz.entities.enums.QuestionType;
import org.youcode.youquiz.mappers.QuestionHasAnswersMapper;
import org.youcode.youquiz.repositories.AnswerRepository;
import org.youcode.youquiz.repositories.QuestionHasAnswersRepository;
import org.youcode.youquiz.repositories.QuestionRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionHasAnswersServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private QuestionHasAnswersRepository hasAnswersRepository;

    @Mock
    private QuestionHasAnswersMapper mapper;

    @InjectMocks
    private QuestionHasAnswersServiceImpl questionHasAnswersService;

    private Question question;
    private Answer answer;
    private QuestionHasAnswersRequestDTO requestDTO;
    private QuestionHasAnswersResponseDTO responseDTO;
    private QuestionHasAnswers questionHasAnswers;

    @BeforeEach
    void setUp() {
        Level level = new Level();
        level.setDescription((LevelType.EASY).toString());
        level.setMinPoints(0);
        level.setMaxPoints(10);

        question = new Question();
        question.setId(1L);
        question.setQuestionType(QuestionType.SINGLE_CHOICE);
        question.setNumberOfAnswers(2);
        question.setNumberOfCorrectAnswers(1);
        question.setLevel(level);

        answer = new Answer();
        answer.setId(1L);

        requestDTO = new QuestionHasAnswersRequestDTO(
                true,
                5.0,
                1L,
                1L
        );

        responseDTO = new QuestionHasAnswersResponseDTO(
                true,
                5.0,
                null,
                null
        );

        questionHasAnswers = new QuestionHasAnswers();
        questionHasAnswers.setId(new QuestionHasAnswersId(1L, 1L));
        questionHasAnswers.setQuestion(question);
        questionHasAnswers.setAnswer(answer);
        questionHasAnswers.setCorrect(true);
        questionHasAnswers.setNote(5.0);
    }

    @Test
    void testCreateQuestionHasAnswers_QuestionNotFound() {
        when(questionRepository.findById(requestDTO.questionId()))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> questionHasAnswersService.create(requestDTO),
                "Question with Id " + requestDTO.questionId() + " does not exist"
        );
    }

    @Test
    void testCreateQuestionHasAnswers_AnswerNotFound() {
        when(questionRepository.findById(requestDTO.questionId()))
                .thenReturn(Optional.of(question));
        when(answerRepository.findById(requestDTO.answerId()))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> questionHasAnswersService.create(requestDTO),
                "Answer with Id " + requestDTO.answerId() + " does not exist"
        );
    }

    @Test
    void testCreateQuestionHasAnswers_MaxAnswersReached() {
        when(questionRepository.findById(requestDTO.questionId()))
                .thenReturn(Optional.of(question));
        when(answerRepository.findById(requestDTO.answerId()))
                .thenReturn(Optional.of(answer));
        when(hasAnswersRepository.countByQuestionId(question.getId()))
                .thenReturn(2L);  // Max answers reached

        assertThrows(IllegalArgumentException.class,
                () -> questionHasAnswersService.create(requestDTO),
                "The total number of answers for the question has been reached."
        );
    }

    @Test
    void testCreateQuestionHasAnswers_SingleChoiceMultipleCorrectAnswers() {
        when(questionRepository.findById(requestDTO.questionId()))
                .thenReturn(Optional.of(question));
        when(answerRepository.findById(requestDTO.answerId()))
                .thenReturn(Optional.of(answer));
        when(hasAnswersRepository.countByQuestionId(question.getId()))
                .thenReturn(0L);
        when(hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true))
                .thenReturn(1L);  // Already has a correct answer

        assertThrows(IllegalArgumentException.class,
                () -> questionHasAnswersService.create(requestDTO),
                "Only one correct answer is allowed for SINGLE_CHOICE questions."
        );
    }

    @Test
    void testCreateQuestionHasAnswers_IncorrectAnswerWithNote() {
        QuestionHasAnswersRequestDTO incorrectRequestDTO = new QuestionHasAnswersRequestDTO(
                false,
                5.0,
                1L,
                1L
        );

        when(questionRepository.findById(incorrectRequestDTO.questionId()))
                .thenReturn(Optional.of(question));
        when(answerRepository.findById(incorrectRequestDTO.answerId()))
                .thenReturn(Optional.of(answer));
        when(hasAnswersRepository.countByQuestionId(question.getId()))
                .thenReturn(0L);

        assertThrows(IllegalArgumentException.class,
                () -> questionHasAnswersService.create(incorrectRequestDTO),
                "If the answer is incorrect, the note must be 0."
        );
    }

    @Test
    void testCreateQuestionHasAnswers_NoteOutOfRange() {
        QuestionHasAnswersRequestDTO outOfRangeRequestDTO = new QuestionHasAnswersRequestDTO(
                true,
                15.0,
                1L,
                1L
        );

        when(questionRepository.findById(outOfRangeRequestDTO.questionId()))
                .thenReturn(Optional.of(question));
        when(answerRepository.findById(outOfRangeRequestDTO.answerId()))
                .thenReturn(Optional.of(answer));
        when(hasAnswersRepository.countByQuestionId(question.getId()))
                .thenReturn(0L);
        when(hasAnswersRepository.countByQuestionIdAndCorrect(question.getId(), true))
                .thenReturn(0L);

        assertThrows(IllegalArgumentException.class,
                () -> questionHasAnswersService.create(outOfRangeRequestDTO),
                "The note must be between 0 and 10 for the question level: BEGINNER"
        );
    }
}