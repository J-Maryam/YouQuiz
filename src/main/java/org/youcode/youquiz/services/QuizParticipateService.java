package org.youcode.youquiz.services;

import org.youcode.youquiz.dtos.participation.ParticipateRequestDTO;

public interface QuizParticipateService {
    void participate(ParticipateRequestDTO participateRequestDTO);
}
