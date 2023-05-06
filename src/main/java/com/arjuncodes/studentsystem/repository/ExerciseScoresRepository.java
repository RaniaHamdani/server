package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.ExerciseScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseScoresRepository extends JpaRepository<ExerciseScore,Integer> {
}
