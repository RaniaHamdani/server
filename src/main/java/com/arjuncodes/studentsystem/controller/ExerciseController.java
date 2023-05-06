package com.arjuncodes.studentsystem.controller;



import com.arjuncodes.studentsystem.model.Exercise;
import com.arjuncodes.studentsystem.service.ExerciseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exercise")
@CrossOrigin
public class ExerciseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/add")
    public String add(@RequestBody Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "New exercises are added";
    }


    @GetMapping("/getAll")
    //  @CrossOrigin(origins = "http://localhost:8000") // Add the allowed frontend origin(s) here
    public List<Exercise> list() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/getDescription")
    public String getExerciseDescription() {
        String query = "SELECT description FROM exercise WHERE id = 1";
        String des = jdbcTemplate.queryForList(query).toString();
        return des;
    }

    @GetMapping("/getScores")
    public List<Map<String, Object>> getScores() throws JsonProcessingException {
        String query = "SELECT id, title, score FROM exercise_score";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Map<String, Object> scores = new HashMap<>();

            scores.put("title", row.get("title"));
            try {
                scores.put("success", row.get("score"));
            } catch (Exception e) {
            }
            result.add(scores);
        }
        return result;
    }

}
