package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.level.LevelRequestDTO;
import org.youcode.youquiz.dtos.level.LevelResponseDTO;
import org.youcode.youquiz.entities.Level;
import org.youcode.youquiz.services.LevelService;

@RestController
@RequestMapping("/api/levels")
public class LevelController extends GenericControllerImpl<Level, Long, LevelRequestDTO, LevelResponseDTO> {
    public LevelController(LevelService service) {
        super(service);
    }
}
