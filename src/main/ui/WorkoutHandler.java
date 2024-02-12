package ui;

import model.Workout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Handles displaying and the inputs for the workouts
 */
public class WorkoutHandler {
    ExerciseHandler handler;

    /*
    EFFECTS: Constructs a new handler
     */
    public WorkoutHandler() {
        handler = new ExerciseHandler();
    }

    /*
        EFFECTS: displays workout
         */
    public void displayWorkout(Workout w) {
        for (int i = 0; i < w.getNumExercise(); i++) {
            handler.displayExercise(w.getExercise(i));
        }
        System.out.println();
    }

    /*
    EFFECTS: gets a workout from inputs
     */
    public Workout inputWorkout() {
        Workout w = new Workout();
        boolean done = false;

        while (!done) {
            w.addExercise(handler.inputExercise());
            done = isDone();
        }

        return w;
    }

    /*
    EFFECTS: returns whether we want to continue adding exercises
     */
    public boolean isDone() {
        String prompt = "Add new exercise (y/n)? ";
        char option = '\u0000';
        Set<Character> validOptions = new HashSet<>(Arrays.asList('y', 'n'));
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println(prompt);
        option = scanner.next().charAt(0);

        while (!validOptions.contains(option)) {
            System.out.println("INVALID INPUT");
            System.out.println();
            System.out.print(prompt);
            option = scanner.next().charAt(0);
        }

        return (option == 'n');
    }
}
