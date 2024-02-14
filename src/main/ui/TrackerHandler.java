package ui;

import model.Tracker;
import model.Workout;

import java.util.Scanner;

/*
Handles tracker inputs and outputs for the main program Tracker class
 */
public class TrackerHandler {
    Tracker tracker;
    WorkoutHandler handler;
    Scanner scanner;

    /*
    MODIFIES: this
    EFFECTS: Constructs a tracker handler
     */
    public TrackerHandler() {
        tracker = new Tracker();
        handler = new WorkoutHandler();
        scanner = new Scanner(System.in);
    }

    /*
    EFFECTS: displays workouts
     */
    public void displayWorkouts() {
        for (int i = 0; i < tracker.getNumWorkouts(); i++) {
            System.out.print(i + ": ");
            Workout w = tracker.getWorkout(i);
            handler.displayWorkout(w);
        }
    }

    /*
    EFFECTS: adds a workout
     */
    public void addWorkout() {
        tracker.addWorkout(handler.inputWorkout());
    }

    /*
    EFFECTS: removes a workout
     */
    public void removeWorkout() {
        displayWorkouts();
        System.out.print("Input the index of workout to remove: ");
        int index = scanner.nextInt();
        tracker.removeWorkout(index);
    }

    /*
    EFFECTS: edits a workout with a specified index
     */
    public void editWorkout() {
        displayWorkouts();
        System.out.print("Input the index of workout to edit: ");
        tracker.editWorkout(scanner.nextInt(), handler.inputWorkout());
    }

    /*
    EFFECTS: views the metrics
     */
    public void viewMetrics() {
        System.out.print("Input the name of the exercise to find: ");
        String exerciseName = scanner.nextLine();
        int maxVol = tracker.findMaxVolume(exerciseName);
        double max1RM = tracker.findMax1RM(exerciseName);

        System.out.println("Maximum volume: " + maxVol);
        System.out.println("Maximum 1RM: " + max1RM);
    }
}
