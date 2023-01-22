package com.debugagent.demo.jpa;

import com.debugagent.demo.dto.ExerciseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String correctAnswer;

    @OneToMany
    private Set<Answer> answers;

    public Exercise() {
    }

    public Exercise(ExerciseDTO exerciseDTO) {
        question = exerciseDTO.question();
        correctAnswer = exerciseDTO.correctAnswer();
    }

    public ExerciseDTO getDTO() {
        return new ExerciseDTO(id, question,
                answers.stream().map(Answer::getAnswer).collect(Collectors.toList()),
                correctAnswer);
    }
}
