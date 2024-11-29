package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;

@Repository
public interface QuestionHasAnswersRepository extends JpaRepository<QuestionHasAnswers, QuestionHasAnswersId> {
}
