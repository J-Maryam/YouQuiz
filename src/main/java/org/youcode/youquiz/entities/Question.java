package org.youcode.youquiz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.youcode.youquiz.entities.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int numberOfAnswers;

    @NotNull
    private int numberOfCorrectAnswers;

    @NotBlank
    private String text;

    @NotNull
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    @NotNull
    private Subject subject;

    @ManyToOne
//    , nullable = false
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<QuizQuestion> quizQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<AnswerValidation> answerValidations = new ArrayList<>();
}
