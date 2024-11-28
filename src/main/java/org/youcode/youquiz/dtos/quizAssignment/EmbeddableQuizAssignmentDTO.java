package org.youcode.youquiz.dtos.quizAssignment;

import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.dtos.student.EmbeddableStudentDTO;

import java.time.LocalDate;

public record EmbeddableQuizAssignmentDTO(
        String reason,
        LocalDate startDate,
        LocalDate endDate,
        int attempt,
        double score,
        double result,
        EmbeddableQuizDTO quiz,
        EmbeddableStudentDTO student
) {
}
