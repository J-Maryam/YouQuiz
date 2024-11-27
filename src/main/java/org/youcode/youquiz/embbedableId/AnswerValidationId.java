package org.youcode.youquiz.embbedableId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record AnswerValidationId(
        @Column(name = "question_id") Long questionId,
        @Column(name = "answer_id") Long answerId
) implements Serializable {
}
