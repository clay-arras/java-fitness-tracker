package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {
    Exercise exercise1;
    Exercise exercise2;
    Exercise exercise3;
    Exercise exercise4;
    Workout workout1;
    Workout workout2;
    Tracker tracker;

    @BeforeEach
    void setUp() {
        exercise1 = new Exercise("Bicep Curls", 6, 3, 20);
        exercise2 = new Exercise("Bench Press", 8, 4, 120);
        exercise3 = new Exercise("Dead Lift", 10, 3, 140);
        exercise4 = new Exercise("Bicep Curls", 8, 4, 40);
        workout1 = new Workout();
        workout2 = new Workout();
        tracker = new Tracker();
        workout1.addExercise(exercise1);
        workout1.addExercise(exercise2);
        workout2.addExercise(exercise3);
        workout2.addExercise(exercise4);
    }

    @Test
    void addWorkout() {
        tracker.addWorkout(workout1);
        assertEquals(tracker.getWorkout(0), workout1);
        tracker.addWorkout(workout2);
        assertEquals(tracker.getWorkout(1), workout2);
    }

    @Test
    void removeWorkout() {
        tracker.addWorkout(workout1);
        tracker.addWorkout(workout2);
        tracker.removeWorkout(0);
        assertEquals(tracker.getWorkout(0), workout2);
    }

    @Test
    void editWorkout() {
        tracker.addWorkout(workout1);
        assertEquals(tracker.getWorkout(0), workout1);
        tracker.editWorkout(0, workout2);
        assertEquals(tracker.getWorkout(0), workout2);
    }

    @Test
    void getWorkout() {
        tracker.addWorkout(workout1);
        assertEquals(tracker.getWorkout(0), workout1);
    }

    @Test
    void getNumWorkouts() {
        assertEquals(tracker.getNumWorkouts(), 0);
        tracker.addWorkout(workout1);
        assertEquals(tracker.getNumWorkouts(), 1);
    }

    @Test
    void findMaxVolume() {
        assertEquals(tracker.findMaxVolume("Bicep Curls"), -1);
        tracker.addWorkout(workout1);
        tracker.addWorkout(workout2);
        assertEquals(tracker.findMaxVolume("Bicep Curls"), workout2.findMaxVolume("Bicep Curls"));
    }

    @Test
    void findMax1RM() {
        assertEquals(tracker.findMax1RM("Bicep Curls"), -1);
        tracker.addWorkout(workout1);
        tracker.addWorkout(workout2);
        assertEquals(tracker.findMax1RM("Bicep Curls"), workout2.findMax1RM("Bicep Curls"));
    }
}