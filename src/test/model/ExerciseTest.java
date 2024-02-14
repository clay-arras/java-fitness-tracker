package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Tests for the Exercise class
 */
class ExerciseTest {
    Exercise exercise1;
    Exercise exercise2;

    @BeforeEach
    void setUp() {
        exercise1 = new Exercise("Bicep Curls", 6, 4, 30);
        exercise2 = new Exercise("Bench Press", 8, 4, 120);
    }

    @Test
    void calculate1RM() {
        assertEquals(exercise1.calculate1RM(),
                exercise1.getExerciseWeight() / (1 - (0.5 / 30) * (exercise1.getExerciseReps() - 1)));
        assertEquals(exercise2.calculate1RM(),
                exercise2.getExerciseWeight() / (1 - (0.5 / 30) * (exercise2.getExerciseReps() - 1)));

        exercise1.setExerciseName("Lat Pull-down");
        exercise1.setExerciseReps(10);
        exercise1.setExerciseSets(3);
        exercise1.setExerciseWeight(100);
        assertEquals(exercise1.calculate1RM(),
                exercise1.getExerciseWeight() / (1 - (0.5 / 30) * (exercise1.getExerciseReps() - 1)));
    }

    @Test
    void calculateVolume() {
        assertEquals(exercise1.calculateVolume(),
                exercise1.getExerciseReps() * exercise1.getExerciseSets() * exercise1.getExerciseWeight());
        assertEquals(exercise2.calculateVolume(),
                exercise2.getExerciseReps() * exercise2.getExerciseSets() * exercise2.getExerciseWeight());
    }
}