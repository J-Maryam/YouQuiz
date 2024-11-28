package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.trainer.TrainerRequestDTO;
import org.youcode.youquiz.dtos.trainer.TrainerResponseDTO;
import org.youcode.youquiz.entities.Trainer;
import org.youcode.youquiz.mappers.TrainerMapper;
import org.youcode.youquiz.repositories.TrainerRepository;
import org.youcode.youquiz.services.TrainerService;

@Service
@Transactional
@Validated
public class TrainerServiceImpl extends GenericServiceImpl<Trainer, Long, TrainerRequestDTO, TrainerResponseDTO> implements TrainerService {
    public TrainerServiceImpl(TrainerRepository repository, TrainerMapper mapper) {
        super(repository, mapper);
    }
}
