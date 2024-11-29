package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.AnswerValidation;
import org.youcode.youquiz.entities.embbedableId.AnswerValidationId;

@Repository
public interface AnswerValidationRepository extends JpaRepository<AnswerValidation, AnswerValidationId> {
}
