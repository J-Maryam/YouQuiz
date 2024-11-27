package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
