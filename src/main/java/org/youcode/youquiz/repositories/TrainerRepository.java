package org.youcode.youquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.youquiz.entities.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
