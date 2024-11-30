package org.youcode.youquiz.dtos.quizAssignment;

import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.dtos.student.EmbeddableStudentDTO;

import java.time.LocalDate;

public record QuizAssignmentResponseDTO(
        String reason,
        LocalDate startDate,
        LocalDate endDate,
        int attempt,
        double score,
        String result,
        EmbeddableQuizDTO quiz,
        EmbeddableStudentDTO student
) {
}
