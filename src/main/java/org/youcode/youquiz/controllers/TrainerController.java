package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.trainer.TrainerRequestDTO;
import org.youcode.youquiz.dtos.trainer.TrainerResponseDTO;
import org.youcode.youquiz.entities.Trainer;
import org.youcode.youquiz.services.TrainerService;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController extends GenericControllerImpl<Trainer, Long, TrainerRequestDTO, TrainerResponseDTO> {
    public TrainerController(TrainerService service) {
        super(service);
    }
}
