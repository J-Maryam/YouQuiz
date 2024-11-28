package org.youcode.youquiz.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "trainer")
public class Trainer extends User {

    @NotBlank
    private String specialty;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();
}
