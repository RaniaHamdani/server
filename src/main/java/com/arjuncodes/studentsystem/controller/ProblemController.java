package com.arjuncodes.studentsystem.controller;



import com.arjuncodes.studentsystem.model.Problem;
import com.arjuncodes.studentsystem.repository.ProblemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/problem")
@CrossOrigin

public class ProblemController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProblemRepository problemRepository;
    @GetMapping("/getAll")
    public List<Problem> getProblems(){
        return problemRepository.findAll();
    }
    private record ProblemRequest(String title, String description, String difficulty,String hint, String tags){}
    @PostMapping("/add")
    public void addProblem(@RequestBody ProblemRequest request){
        Problem problem = new Problem();
        problem.setDescription(request.description());
        problem.setDifficulty(request.difficulty());
        problem.setHint(request.hint());
        problem.setTitle(request.title());
        problem.setTags(request.tags());
        problemRepository.save(problem);
    }

    @GetMapping("/getScores")
    public List<Map<String, Object>> getScores() throws JsonProcessingException {
        String query = "SELECT id, title, score FROM problem_score";
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
