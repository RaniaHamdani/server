package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Interview;
import com.arjuncodes.studentsystem.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/interview")
@CrossOrigin
public class InterviewController {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        Interview savedInterview = interviewRepository.save(interview);
        return ResponseEntity.ok(savedInterview);
    }



    @GetMapping("/scores")
    public  List<Map<String, Object>> getInterviewsScore() {
        String query = "SELECT role, score FROM interview_scores";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        return rows;

    }

    @GetMapping("/interviews")
    public  List<Map<String, Object>> getInterviews() {
        String query = "SELECT * FROM interview";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        return rows;

    }

    @GetMapping("/questions")
    public  List<Map<String, Object>> getQuestions() {
        String query = "SELECT question, option1, option2, option3, option4, answer FROM question";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Map<String, Object>> quiz = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Map<String, Object> question = new HashMap<>();
            question.put("question", row.get("question"));
            List<String> options = new ArrayList<>();
            options.add((String) row.get("option1"));
            options.add((String) row.get("option2"));
            options.add((String) row.get("option3"));
            options.add((String) row.get("option4"));
            question.put("options", options);
            question.put("answer", row.get("answer"));
            quiz.add(question);
        }
        return quiz;
    }



}
