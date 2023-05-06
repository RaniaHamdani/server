package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository  extends JpaRepository<Problem, Integer> {
}
