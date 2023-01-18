package com.debugagent.demo.rest;

import com.debugagent.demo.dto.ExerciseDTO;
import com.debugagent.demo.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExerciseWebService {
    private final ExerciseService exerciseService;

    @GetMapping("/getExercise")
    public ExerciseDTO getExercise() {
        return exerciseService.getExercise();
    }

    @PostMapping("/submitExercise")
    public void submitExercise(@RequestBody ExerciseDTO exerciseDTO) {
        exerciseService.submitExercise(exerciseDTO);
    }
}
