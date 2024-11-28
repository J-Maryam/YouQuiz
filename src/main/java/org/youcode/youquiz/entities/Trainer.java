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
public class Trainer extends User {

    @NotBlank
    private String specialty;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();
}
