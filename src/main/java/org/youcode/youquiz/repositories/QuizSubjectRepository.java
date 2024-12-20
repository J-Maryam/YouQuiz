package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.QuizSubject;
import org.youcode.youquiz.entities.embbedableId.QuizSubjectId;

import java.util.List;

@Repository
public interface QuizSubjectRepository extends JpaRepository<QuizSubject, QuizSubjectId> {
    List<QuizSubject> findAllByQuizId(Long quizId);
}
