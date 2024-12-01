package org.youcode.youquiz.entities.embbedableId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public record AnswerValidationId(
        @Column(name = "question_id") Long questionId,
        @Column(name = "answer_id") Long answerId,
        @Column(name = "quiz_id") Long quizId,
        @Column(name = "student_id") Long studentId
) implements Serializable {
}
