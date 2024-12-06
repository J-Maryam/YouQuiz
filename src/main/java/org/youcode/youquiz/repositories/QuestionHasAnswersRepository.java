package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.QuestionHasAnswers;
import org.youcode.youquiz.entities.embbedableId.QuestionHasAnswersId;

@Repository
public interface QuestionHasAnswersRepository extends JpaRepository<QuestionHasAnswers, QuestionHasAnswersId> {
    Long countByQuestionId(Long questionId);
    Long countByQuestionIdAndCorrect(Long questionId, boolean isTrue);
    @Query("SELECT SUM(qha.note) FROM QuestionHasAnswers qha WHERE qha.question.id = :questionId")
    double sumNoteByQuestionId(@Param("questionId") Long questionId);}
