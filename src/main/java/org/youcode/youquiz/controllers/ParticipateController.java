package org.youcode.youquiz.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.youquiz.common.ApiResponse;
import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;
import org.youcode.youquiz.dtos.participation.QuizResultDTO;
import org.youcode.youquiz.services.QuizParticipateService;

import java.util.List;

@RestController
@RequestMapping("/api/participate")
@RequiredArgsConstructor
public class ParticipateController {
    private final QuizParticipateService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> participate(@RequestBody @Valid ParticipateRequestDTO requestDto) {
         service.participate(requestDto);
        return ResponseEntity.ok(ApiResponse.success(null, "Participation created successfully"));
    }

    @GetMapping("/result/quiz/{quizId}/student/{studentId}")
    public ResponseEntity<ParticipationResultDTO> getResult(@PathVariable("quizId") Long quizId, @PathVariable("studentId") Long studentId) {
        ParticipationResultDTO result = service.getQuizResult(quizId, studentId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/result/{quizId}")
    public ResponseEntity<QuizResultDTO> getQuizResults(@PathVariable Long quizId) {
        QuizResultDTO result = service.getQuizResultsByQuiz(quizId);
        return ResponseEntity.ok(result);
    }

}
