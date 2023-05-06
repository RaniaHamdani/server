package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.InterviewScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewScoresRepository extends JpaRepository<InterviewScore, Integer> {
}
