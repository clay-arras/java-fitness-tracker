package ui.tui;

import model.Tracker;
import model.Workout;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
Handles tracker inputs and outputs for the main program Tracker class
 */
public class TrackerHandler {
    Tracker tracker;
    WorkoutHandler handler;
    Scanner scanner;
    private static final String JSON_STORE = "./data/userData.json";
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    /*
    MODIFIES: this
    EFFECTS: Constructs a tracker handler
     */
    public TrackerHandler() {
        tracker = new Tracker();
        handler = new WorkoutHandler();
        scanner = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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

    protected void saveTracker() {
        try {
            jsonWriter.open();
            jsonWriter.write(tracker);
            jsonWriter.close();
            System.out.println("Saved file to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    protected void loadTracker() {
        try {
            tracker = jsonReader.read();
            System.out.println("Loaded file from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
