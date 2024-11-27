package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.subject.SubjectRequestDTO;
import org.youcode.youquiz.dtos.subject.SubjectResponseDTO;
import org.youcode.youquiz.entities.Subject;
import org.youcode.youquiz.services.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController extends GenericControllerImpl<Subject, Long, SubjectRequestDTO, SubjectResponseDTO> {
    public SubjectController(SubjectService service) {
        super(service);
    }
}
