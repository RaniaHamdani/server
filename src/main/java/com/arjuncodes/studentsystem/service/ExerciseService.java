package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Exercise;

import java.util.List;

public interface ExerciseService {

    public String saveExercise(Exercise exercise);
    public List<Exercise> getAllExercises();
    public String getExerciseDescription(Integer exerciseId);

}
