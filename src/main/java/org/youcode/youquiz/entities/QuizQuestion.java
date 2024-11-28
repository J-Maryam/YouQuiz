package org.youcode.youquiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.youcode.youquiz.entities.embbedableId.QuizQuestionId;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {

    @EmbeddedId
    private QuizQuestionId id;

    private int timer;

    @ManyToOne
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;
}
