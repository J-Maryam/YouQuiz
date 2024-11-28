package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.QuizAssignment;
import org.youcode.youquiz.entities.embbedableId.QuizAssignmentId;

@Repository
public interface QuizAssignmentRepository extends JpaRepository<QuizAssignment, QuizAssignmentId> {
}
