package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
