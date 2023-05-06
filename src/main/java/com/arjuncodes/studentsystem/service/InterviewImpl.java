package com.arjuncodes.studentsystem.service;
import com.arjuncodes.studentsystem.model.Interview;
import com.arjuncodes.studentsystem.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class InterviewImpl {
    @Autowired
    private InterviewRepository interviewRepository;
    public String saveInterview(Interview interview) {
        interviewRepository.save(interview);
        return interview.toString();
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
}
