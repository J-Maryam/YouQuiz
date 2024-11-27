package org.youcode.youquiz.entities.embbedableId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record QuizSubjectId(
        @Column(name = "quiz_id") Long quizId,
        @Column(name = "subject_id") Long subjectId
) implements Serializable {
}
