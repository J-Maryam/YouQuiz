package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectRequestDTO;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectResponseDTO;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.embbedableId.QuizSubjectId;
import org.youcode.youquiz.services.QuizSubjectService;

@RestController
@RequestMapping("/api/quiz_subjects")
public class QuizSubjectController extends GenericControllerImpl<QuizSubject, QuizSubjectId, QuizSubjectRequestDTO, QuizSubjectResponseDTO> {

    public QuizSubjectController(QuizSubjectService service) {
        super(service);
    }
}
