package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.trainer.TrainerRequestDTO;
import org.youcode.youquiz.dtos.trainer.TrainerResponseDTO;
import org.youcode.youquiz.entities.Trainer;

public interface TrainerService extends GenericService<Trainer, Long, TrainerRequestDTO, TrainerResponseDTO> {
}
