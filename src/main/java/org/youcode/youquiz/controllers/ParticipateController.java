package org.youcode.youquiz.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.youquiz.common.ApiResponse;
import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;
import org.youcode.youquiz.services.QuizParticipateService;

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

    @GetMapping("/result/{quizId}/{studentId}")
    public ResponseEntity<ParticipationResultDTO> getResult(@PathVariable("quizId") Long quizId, @PathVariable("studentId") Long studentId) {
        ParticipationResultDTO result = service.getQuizResult(quizId, studentId);
        return ResponseEntity.ok(result);
    }

}
