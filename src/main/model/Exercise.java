package model;

/*
Represents one exercise, where we can calculate certain metrics through functions
 */
public class Exercise {
    private String exerciseName;
    private int exerciseReps;
    private int exerciseSets;
    private int exerciseWeight;

    /*
    EFFECTS: constructs an exercise
     */
    public Exercise(String exerciseName, int exerciseReps, int exerciseSets, int exerciseWeight) {
        this.exerciseName = exerciseName;
        this.exerciseReps = exerciseReps;
        this.exerciseSets = exerciseSets;
        this.exerciseWeight = exerciseWeight;
    }

    /*
    EFFECTS: generates the 1RM
     */
    public double calculate1RM() {
        return exerciseWeight / (1 - (0.5 / 30) * (exerciseReps - 1));
    }

    /*
    EFFECTS: calculates the volume
     */
    public int calculateVolume() {
        return exerciseReps * exerciseSets * exerciseWeight;
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
