package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.QuizQuestion;
import org.youcode.youquiz.entities.embbedableId.QuizQuestionId;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, QuizQuestionId> {
    boolean existsByQuizIdAndQuestionId(Long quizId, Long questionId);
}
