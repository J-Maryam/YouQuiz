package org.youcode.youquiz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.youquiz.common.ApiResponse;
import org.youcode.youquiz.common.controllers.GenericControllerImpl;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersRequestDTO;
import org.youcode.youquiz.dtos.questionHasAnswers.QuestionHasAnswersResponseDTO;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;
import org.youcode.youquiz.services.QuestionHasAnswersService;

import java.util.List;

@RestController
@RequestMapping("/api/question_has_answers")
public class QuestionHasAnswersController extends GenericControllerImpl<QuestionHasAnswers, QuestionHasAnswersId, QuestionHasAnswersRequestDTO, QuestionHasAnswersResponseDTO> {
    private final QuestionHasAnswersService questionHasAnswersService;
    public QuestionHasAnswersController(QuestionHasAnswersService service, QuestionHasAnswersService questionHasAnswersService) {
        super(service);
        this.questionHasAnswersService = questionHasAnswersService;
    }

    @GetMapping("/by-question/{questionId}")
    public ResponseEntity<ApiResponse<List<QuestionHasAnswersResponseDTO>>> getByQuestionId(@PathVariable Long questionId) {
        List<QuestionHasAnswersResponseDTO> responses = questionHasAnswersService.getByQuestionId(questionId);
        return ResponseEntity.ok(ApiResponse.success(responses, "Question answers retrieved successfully"));
    }
}
