package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.exceptions.EntityNotFoundException;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.quiz.QuizRequestDTO;
import org.youcode.youquiz.dtos.quiz.QuizResponseDTO;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.Trainer;
import org.youcode.youquiz.mappers.QuizMapper;
import org.youcode.youquiz.repositories.QuizRepository;
import org.youcode.youquiz.repositories.TrainerRepository;
import org.youcode.youquiz.services.QuizService;

@Service
@Validated
@Transactional
public class QuizServiceImpl extends GenericServiceImpl<Quiz, Long, QuizRequestDTO, QuizResponseDTO> implements QuizService {

    private TrainerRepository trainerRepository;
    public QuizServiceImpl(QuizRepository repository, QuizMapper mapper, TrainerRepository trainerRepository) {
        super(repository, mapper);
        this.trainerRepository = trainerRepository;
    }

    @Override
    public QuizResponseDTO create(QuizRequestDTO requestDto) {
        Trainer existingTrainer = trainerRepository.findById(requestDto.trainerId())
                .orElseThrow(() -> new EntityNotFoundException("Trainer with Id " + requestDto.trainerId() + " does not exist"));

        Quiz quiz = mapper.toEntity(requestDto);
        quiz.setTrainer(existingTrainer);
        Quiz saved = repository.save(quiz);
        return mapper.toDto(saved);
    }
}
