package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository  extends JpaRepository<Interview, Integer>{
}
