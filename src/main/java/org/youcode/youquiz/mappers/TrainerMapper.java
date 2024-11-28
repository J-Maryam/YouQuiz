package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.trainer.TrainerRequestDTO;
import org.youcode.youquiz.dtos.trainer.TrainerResponseDTO;
import org.youcode.youquiz.entities.Trainer;

@Mapper(componentModel = "spring")
public interface TrainerMapper extends GenericMapper<Trainer, TrainerRequestDTO, TrainerResponseDTO> {
}
