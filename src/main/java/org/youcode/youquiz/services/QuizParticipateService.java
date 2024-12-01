package org.youcode.youquiz.services;

import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;
import org.youcode.youquiz.dtos.participation.ParticipationResultDTO;

public interface QuizParticipateService {
    void participate(ParticipateRequestDTO participateRequestDTO);
    ParticipationResultDTO getQuizResult(Long quizId, Long studentId);
}
