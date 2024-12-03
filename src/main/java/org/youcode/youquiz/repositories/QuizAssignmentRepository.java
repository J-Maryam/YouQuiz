package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Quiz;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;

import java.util.List;

@Repository
public interface QuizAssignmentRepository extends JpaRepository<QuizAssignment, QuizAssignmentId> {
    List<QuizAssignment> findByQuizId(Long quizId);
}
