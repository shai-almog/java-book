package com.debugagent.demo.web;

import com.debugagent.demo.dto.ExerciseDTO;
import com.debugagent.demo.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class WebUI {
    private final ExerciseService exerciseService;

    @GetMapping("/question")
    public String question(Model model) {
        ExerciseDTO exerciseDTO = exerciseService.getExercise();
        model.addAttribute("question", exerciseDTO.question());
        var answers = new ArrayList<>(exerciseDTO.incorrectAnswers());
        answers.add(exerciseDTO.correctAnswer());
        Collections.shuffle(answers);
        model.addAttribute("answers", answers);
        model.addAttribute("questionId", exerciseDTO.questionId());
        return "template";
    }

    @PostMapping("/answer")
    public String answer(@ModelAttribute ExerciseDTO body) {
        Long id = body.questionId();
        ExerciseDTO exerciseDTO = exerciseService.getExerciseById(id);
        if(body.correctAnswer().equals(exerciseDTO.correctAnswer())) {
            return "correct";
        }
        return "incorrect";
    }
}
