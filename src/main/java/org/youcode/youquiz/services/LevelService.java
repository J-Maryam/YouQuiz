package org.youcode.youquiz.services;

import org.youcode.youquiz.common.services.GenericService;
import org.youcode.youquiz.dtos.level.LevelRequestDTO;
import org.youcode.youquiz.dtos.level.LevelResponseDTO;
import org.youcode.youquiz.entities.Level;

public interface LevelService extends GenericService<Level, Long, LevelRequestDTO, LevelResponseDTO> {
}
