package org.youcode.youquiz.mappers;

import org.mapstruct.Mapper;
import org.youcode.youquiz.common.Mapper.GenericMapper;
import org.youcode.youquiz.dtos.level.LevelRequestDTO;
import org.youcode.youquiz.dtos.level.LevelResponseDTO;
import org.youcode.youquiz.entities.Level;

@Mapper(componentModel = "spring")
public interface LevelMapper extends GenericMapper<Level, LevelRequestDTO, LevelResponseDTO> {
}
