package org.youcode.youquiz.dtos.participation;

import java.util.List;

public record QuizResultDTO(
        String title,
        double successScore,
        List<StudentResultDTO> students
) {
    public record StudentResultDTO(
//            Long studentId,
            String firstName,
            String lastName,
            double score,
            String result,
            Integer attempt
    ) {
    }
}
