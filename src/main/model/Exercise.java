package model;

import org.json.JSONObject;
import persistence.Writable;

/*
Represents one exercise, where we can calculate certain metrics through functions
 */
public class Exercise implements Writable {
    private String exerciseName;
    private int exerciseReps;
    private int exerciseSets;
    private int exerciseWeight;

    /*
    MODIFIES: this
    EFFECTS: constructs an exercise
     */
    public Exercise(String exerciseName, int exerciseReps, int exerciseSets, int exerciseWeight) {
        this.exerciseName = exerciseName;
        this.exerciseReps = exerciseReps;
        this.exerciseSets = exerciseSets;
        this.exerciseWeight = exerciseWeight;
    }

    /*
    REQUIRES: exerciseWeight > 0 && exerciseReps > 0 && exerciseSets > 0
    EFFECTS: generates the 1RM
     */
    public double calculate1RM() {
        return exerciseWeight / (1 - (0.5 / 30) * (exerciseReps - 1));
    }

    /*
    REQUIRES: exerciseWeight > 0 && exerciseReps > 0 && exerciseSets > 0
    EFFECTS: calculates the volume
     */
    public int calculateVolume() {
        return exerciseReps * exerciseSets * exerciseWeight;
    }

    /*
    EFFECTS: returns a JSON object
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("exerciseName", exerciseName);
        json.put("exerciseReps", exerciseReps);
        json.put("exerciseSets", exerciseSets);
        json.put("exerciseWeight", exerciseWeight);
        return json;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getExerciseReps() {
        return exerciseReps;
    }

    public void setExerciseReps(int exerciseReps) {
        this.exerciseReps = exerciseReps;
    }

    public int getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(int exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public int getExerciseWeight() {
        return exerciseWeight;
    }

    public void setExerciseWeight(int exerciseWeight) {
        this.exerciseWeight = exerciseWeight;
    }
}
