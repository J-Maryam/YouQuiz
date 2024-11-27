package org.youcode.youquiz.embbedableId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record QuizQuestionId(
        @Column(name = "quiz_id") Long quizId,
        @Column(name = "question_id") Long questionId
) implements Serializable {
}
