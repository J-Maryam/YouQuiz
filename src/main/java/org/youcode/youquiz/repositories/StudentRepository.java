package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
