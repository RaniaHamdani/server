package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
