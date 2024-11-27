package org.youcode.youquiz.embbedableId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record QuizAssignmentId(
        @Column(name = "quiz_id") Long quizId,
        @Column(name = "student_id") Long studentId
) implements Serializable {
}
