package org.youcode.youquiz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidation {

    @EmbeddedId
    private AnswerValidationId id;

    @NotNull
    private double points;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    private Answer answer;

//    @ManyToOne
//    @MapsId("quizId")  // Lier à QuizAssignment via quizId
//    private QuizAssignment quizAssignment;
//
//    @ManyToOne
//    @MapsId("studentId")  // Lier à QuizAssignment via studentId
//    private Student student;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id"),
//            @JoinColumn(name = "student_id", referencedColumnName = "student_id")
//    })
//    private QuizAssignment quizAssignment;

    @ManyToOne
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;  // Changez de QuizAssignment à Quiz

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
}
