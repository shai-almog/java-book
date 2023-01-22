package com.debugagent.demo.dto;

import java.util.List;

public record ExerciseDTO(long questionId, String question, List<String> incorrectAnswers, String correctAnswer) {
}
