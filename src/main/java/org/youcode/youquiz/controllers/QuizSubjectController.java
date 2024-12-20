package org.youcode.youquiz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectRequestDTO;
import org.youcode.youquiz.dtos.quizSubject.QuizSubjectResponseDTO;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.embbedableId.QuizSubjectId;
import org.youcode.youquiz.services.QuizSubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz_subjects")
public class QuizSubjectController extends GenericControllerImpl<QuizSubject, QuizSubjectId, QuizSubjectRequestDTO, QuizSubjectResponseDTO> {

    private final QuizSubjectService quizSubjectService;

    public QuizSubjectController(QuizSubjectService service, QuizSubjectService quizSubjectService) {
        super(service);
        this.quizSubjectService = quizSubjectService;
    }

    @GetMapping("/by-quiz/{quizId}")
    public List<QuizSubjectResponseDTO> getByQuiz(@PathVariable Long quizId) {
        return quizSubjectService.getByQuiz(quizId);
    }
}
