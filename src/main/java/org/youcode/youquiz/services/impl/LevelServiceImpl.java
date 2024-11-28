package org.youcode.youquiz.services.impl;

import org.springframework.stereotype.Service;
import org.youcode.youquiz.common.services.GenericServiceImpl;
import org.youcode.youquiz.dtos.level.LevelRequestDTO;
import org.youcode.youquiz.dtos.level.LevelResponseDTO;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.mappers.LevelMapper;
import org.youcode.youquiz.repositories.LevelRepository;
import org.youcode.youquiz.services.LevelService;

@Service
public class LevelServiceImpl extends GenericServiceImpl<Level, Long, LevelRequestDTO, LevelResponseDTO> implements LevelService {
    public LevelServiceImpl(LevelRepository repository, LevelMapper mapper) {
        super(repository, mapper);
    }
}
