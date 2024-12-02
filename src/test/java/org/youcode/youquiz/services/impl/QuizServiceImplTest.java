package org.youcode.youquiz.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.dtos.quiz.QuizRequestDTO;
import org.youcode.youquiz.dtos.quiz.QuizResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.Trainer;
import org.youcode.youquiz.mappers.QuizMapper;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.repositories.TrainerRepository;
import org.youcode.youquiz.services.QuizService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {

    @Mock
    private QuizRepository quizRepository;

    @Mock
    private QuizMapper quizMapper;

    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    private QuizRequestDTO quizRequestDTO;
    private QuizResponseDTO quizResponseDTO;
    private Quiz quiz;
    private Trainer trainer;

    @BeforeEach
    void setUp() {
        trainer = new Trainer();
        trainer.setId(1L);

        quiz = new Quiz();
        quiz.setId(1L);
        quiz.setTrainer(trainer);

        quizRequestDTO = new QuizRequestDTO(
                "Test Quiz",
                0,
                false,
                false,
                1,
                "first attempt",
                1L
        );

        quizResponseDTO = new QuizResponseDTO(
                1L,
                "Test Quiz",
                0,
                false,
                false,
                1,
                "first attempt",
                null
        );
    }

    @Test
    void testCreateQuiz_Success() {
        when(trainerRepository.findById(quizRequestDTO.trainerId()))
                .thenReturn(Optional.of(trainer));
        when(quizMapper.toEntity(quizRequestDTO)).thenReturn(quiz);
        when(quizRepository.save(quiz)).thenReturn(quiz);
        when(quizMapper.toDto(quiz)).thenReturn(quizResponseDTO);

        QuizResponseDTO result = quizService.create(quizRequestDTO);

        assertNotNull(result);
        assertEquals(quizResponseDTO.id(), result.id());
        verify(trainerRepository).findById(quizRequestDTO.trainerId());
        verify(quizRepository).save(quiz);
    }

    @Test
    void testCreateQuiz_TrainerNotFound() {
        // Arrange
        when(trainerRepository.findById(quizRequestDTO.trainerId()))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class,
                () -> quizService.create(quizRequestDTO),
                "Trainer with Id " + quizRequestDTO.trainerId() + " does not exist"
        );
    }

    @Test
    void testGetQuizById_Success() {
        when(quizRepository.findById(1L)).thenReturn(Optional.of(quiz));
        when(quizMapper.toDto(quiz)).thenReturn(quizResponseDTO);

        QuizResponseDTO result = quizService.getById(1L);

        assertNotNull(result);
        assertEquals(quizResponseDTO.id(), result.id());
        verify(quizRepository).findById(1L);
    }

    @Test
    void testGetQuizById_NotFound() {
        // Arrange
        when(quizRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class,
                () -> quizService.getById(1L),
                "Entity with Id 1 not found"
        );
    }

    @Test
    void testUpdateQuiz_Success() {
        // Arrange
        when(quizRepository.existsById(1L)).thenReturn(true);
        when(quizMapper.toEntity(quizRequestDTO)).thenReturn(quiz);
        when(quizRepository.save(quiz)).thenReturn(quiz);
        when(quizMapper.toDto(quiz)).thenReturn(quizResponseDTO);

        // Act
        QuizResponseDTO result = quizService.update(1L, quizRequestDTO);

        // Assert
        assertNotNull(result);
        assertEquals(quizResponseDTO.id(), result.id());
        verify(quizRepository).existsById(1L);
        verify(quizRepository).save(quiz);
    }

    @Test
    void testUpdateQuiz_NotFound() {
        // Arrange
        when(quizRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(EntityNotFoundException.class,
                () -> quizService.update(1L, quizRequestDTO),
                "Entity with Id 1 not found"
        );
    }

    @Test
    void testDeleteQuiz_Success() {
        // Arrange
        when(quizRepository.findById(1L)).thenReturn(Optional.of(quiz));

        // Act
        quizService.delete(1L);

        // Assert
        verify(quizRepository).findById(1L);
        verify(quizRepository).delete(quiz);
    }

    @Test
    void testDeleteQuiz_NotFound() {
        // Arrange
        when(quizRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class,
                () -> quizService.delete(1L),
                "Entity with Id 1 not found"
        );
    }
}