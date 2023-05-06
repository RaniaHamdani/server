package com.arjuncodes.studentsystem.service;


import com.arjuncodes.studentsystem.model.Exercise;
import com.arjuncodes.studentsystem.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public String saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return "exercices added";
    }


    @Override
    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises;
    }

    @Override
    public String getExerciseDescription(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not found with id: " + exerciseId));
        return exercise.getDescription();
    }
}
