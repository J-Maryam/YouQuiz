package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
