package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
