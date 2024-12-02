package org.youcode.youquiz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject", fetch = FetchType.EAGER)
    private List<Subject> subSubjects = new ArrayList<>();

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private List<QuizSubject> quizSubjects = new ArrayList<>();
}
