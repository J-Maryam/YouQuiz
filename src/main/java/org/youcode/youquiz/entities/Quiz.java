package org.youcode.youquiz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private double successScore;

    @NotBlank
    private boolean canSeeAnswers;

    @NotBlank
    private boolean canSeeResult;

    @NotNull
    private Integer numberOfAttempts;

    @NotBlank
    private String remark;

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    @OneToMany(mappedBy = "quiz")
    private List<QuizAssignment> quizAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "quiz")
    private List<QuizQuestion> quizQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "quiz")
    private List<QuizSubject> quizSubjects = new ArrayList<>();
}
