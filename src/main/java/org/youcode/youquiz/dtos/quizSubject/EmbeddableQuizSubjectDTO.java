package org.youcode.youquiz.dtos.quizSubject;

import org.youcode.youquiz.dtos.quiz.EmbeddableQuizDTO;
import org.youcode.youquiz.dtos.subject.EmbeddableSubjectDTO;

public record EmbeddableQuizSubjectDTO(
        EmbeddableQuizDTO quiz,
        EmbeddableSubjectDTO subject
) {
}