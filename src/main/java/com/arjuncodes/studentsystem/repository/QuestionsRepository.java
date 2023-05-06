package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}
