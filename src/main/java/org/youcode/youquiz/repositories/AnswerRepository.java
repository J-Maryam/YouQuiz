package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
