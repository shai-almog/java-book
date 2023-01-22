package com.debugagent.demo.service;

import com.debugagent.demo.db.DBAccess;
import com.debugagent.demo.dto.ExerciseDTO;
import com.debugagent.demo.jpa.Answer;
import com.debugagent.demo.jpa.AnswerRepository;
import com.debugagent.demo.jpa.Exercise;
import com.debugagent.demo.jpa.ExerciseRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ExerciseService {
    private static final ExerciseDTO[] EXERCISES = {
            new ExerciseDTO(1,"1/2 * 1/2 =", List.of("2/2", "1/2", "1/8"), "1/4"),
            new ExerciseDTO(2,"1/2 + 1/2 =", List.of("2/2", "1/2", "1/8"), "1"),
            new ExerciseDTO(3,"1/2 : 1/2 =", List.of("2/2", "1/2", "1/8"), "1"),
            new ExerciseDTO(4,"1/2 - 1/2 =", List.of("0/2", "-1/2", "1/0"), "0")
    };

    private final Random RANDOM = new Random();

    private final ExerciseRepository exerciseRepository;
    private final AnswerRepository answerRepository;

    @PostConstruct
    public void init() {
        for(ExerciseDTO exerciseDTO : EXERCISES) {
            saveExercise(exerciseDTO);
        }
    }

    private void saveExercise(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise(exerciseDTO);
        Set<Answer> answers = new HashSet<>();
        for(String answer : exerciseDTO.incorrectAnswers()) {
            answers.add(new Answer(answer));
        }
        answerRepository.saveAll(answers);
        exercise.setAnswers(answers);
        exerciseRepository.save(exercise);
    }

    public ExerciseDTO getExercise() {
        return exerciseRepository.findAll()
                .get(RANDOM.nextInt((int)exerciseRepository.count())).getDTO();
    }

    public ExerciseDTO getExerciseById(long id) {
        return exerciseRepository.findById(id)
                .orElseThrow()
                .getDTO();
    }

    public void submitExercise(ExerciseDTO exerciseDTO) {
        saveExercise(exerciseDTO);
    }
}
