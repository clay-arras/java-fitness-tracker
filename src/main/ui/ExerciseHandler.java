package ui;

import model.Exercise;

import java.util.Scanner;

/*
Handles displaying and the inputs for the workouts
 */
public class ExerciseHandler {
    /*
    EFFECTS: displays workout
     */
    public void displayExercise(Exercise e) {
        System.out.println(e.getExerciseName());
        for (int i = 0; i < e.getExerciseSets(); i++) {
            System.out.println(e.getExerciseReps() + " x " + e.getExerciseWeight() + "lbs");
        }
    }

    /*
    EFFECTS: gets a workout from inputs
     */
    public Exercise inputExercise() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input exercise name: ");
        String exerciseName = scanner.nextLine();
        System.out.print("Input exercise sets: ");
        int exerciseSets = scanner.nextInt();
        System.out.print("Input exercise reps: ");
        int exerciseReps = scanner.nextInt();
        System.out.print("Input exercise weight (lbs): ");
        int exerciseWeight = scanner.nextInt();

        return new Exercise(exerciseName, exerciseReps, exerciseSets, exerciseWeight);
    }
}
