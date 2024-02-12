package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    Exercise exercise1;
    Exercise exercise2;
    Exercise exercise3;
    Workout workout;

    @BeforeEach
    void setUp() {
        exercise1 = new Exercise("Bicep Curls", 6, 4, 30);
        exercise2 = new Exercise("Bench Press", 8, 4, 120);
        exercise3 = new Exercise("Dead Lift", 10, 3, 140);
        workout = new Workout();
    }

    @Test
    void addExercise() {
        workout.addExercise(exercise1);
        assertEquals(workout.getExercise(0), exercise1);
        workout.addExercise(exercise2);
        assertEquals(workout.getExercise(1), exercise2);
    }

    @Test
    void removeExercise() {
        workout.addExercise(exercise1);
        workout.addExercise(exercise2);
        workout.removeExercise(0);
        assertEquals(workout.getExercise(0), exercise2);
    }

    @Test
    void editExercise() {
        workout.addExercise(exercise1);
        assertEquals(workout.getExercise(0), exercise1);
        workout.editExercise(0, exercise2);
        assertEquals(workout.getExercise(0), exercise2);
    }

    @Test
    void getExercise() {
        workout.addExercise(exercise3);
        assertEquals(workout.getExercise(0), exercise3);
    }

    @Test
    void getNumWorkouts() {
        assertEquals(workout.getNumExercise(), 0);
        workout.addExercise(exercise1);
        assertEquals(workout.getNumExercise(), 1);
        workout.addExercise(exercise2);
        assertEquals(workout.getNumExercise(), 2);
    }

    @Test
    void findMaxVolume() {
        assertEquals(workout.findMaxVolume("Bicep Curls"), -1);
        workout.addExercise(exercise1);
        assertEquals(workout.findMaxVolume("Bicep Curls"), exercise1.calculateVolume());
        workout.addExercise(exercise3);
        assertEquals(workout.findMaxVolume("Dead Lift"), exercise3.calculateVolume());
    }

    @Test
    void findMax1RM() {
        assertEquals(workout.findMax1RM("Bicep Curls"), -1);
        workout.addExercise(exercise1);
        assertEquals(workout.findMax1RM("Bicep Curls"), exercise1.calculate1RM());
        workout.addExercise(exercise3);
        assertEquals(workout.findMax1RM("Dead Lift"), exercise3.calculate1RM());
    }
}