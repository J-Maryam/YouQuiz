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

    @Override
    public LevelResponseDTO create(LevelRequestDTO requestDTO) {
        validateLevelPoints(requestDTO.minPoints(), requestDTO.maxPoints());
        Level level = mapper.toEntity(requestDTO);
        Level saved = repository.save(level);
        return mapper.toDto(saved);
    }

    private void validateLevelPoints(Integer minPoints, Integer maxPoints) {
        if (minPoints < 0) {
            throw new IllegalArgumentException("Minimum points cannot be negative");
        }
        if (maxPoints <= minPoints) {
            throw new IllegalArgumentException("Maximum points must be greater than minimum points");
        }
    }

}
