package model;

import java.util.ArrayList;

import static java.lang.Math.max;

/*
This method represents a single workout, which logs some arbitrary number of exercises
 */
public class Workout {
    private final ArrayList<Exercise> listOfExercise;

    /*
    EFFECTS: constructs a new workout
     */
    public Workout() {
        listOfExercise = new ArrayList<>();
    }

    /*
    REQUIRES: newExercise.getExerciseName not in listOfExercise
    MODIFIES: listOfExercise
    EFFECTS: adds a new exercise
     */
    public void addExercise(Exercise newExercise) {
        listOfExercise.add(newExercise);
    }

    /*
    REQUIRES: newExercise in listOfExercise
    MODIFIES: listOfExercise
    EFFECTS: removes an exercise
     */
    public void removeExercise(int index) {
        listOfExercise.remove(index);
    }

    /*
    REQUIRES: newExercise in listOfExercise
    MODIFIES: listOfExercise
    EFFECTS: changes an exercise
     */
    public void editExercise(int index, Exercise newExercise) {
        listOfExercise.set(index, newExercise);
    }

    /*
    REQUIRES: index < listOfExercises.size()
    EFFECTS: gets an exercise
     */
    public Exercise getExercise(int index) {
        return listOfExercise.get(index);
    }

    /*
    EFFECTS: get the length of the workouts
     */
    public int getNumExercise() {
        return listOfExercise.size();
    }

    /*
    EFFECTS: finds the maximum volume among all exercises with that exercise name
     */
    public int findMaxVolume(String exerciseName) {
        int maxVolume = -1;
        for (Exercise exercise : listOfExercise) {
            if (exercise.getExerciseName().equals(exerciseName)) {
                maxVolume = max(maxVolume, exercise.calculateVolume());
            }
        }
        return maxVolume;
    }

    /*
    EFFECTS: finds the maximum 1RM among all exercises with that exercise name
     */
    public double findMax1RM(String exerciseName) {
        double max1RM = -1;
        for (Exercise exercise : listOfExercise) {
            if (exercise.getExerciseName().equals(exerciseName)) {
                max1RM = max(max1RM, exercise.calculate1RM());
            }
        }
        return max1RM;
    }

    /*
    EFFECTS: finds the exercise with this exercise name, or returns -1
     */
//    public Exercise findExercise(String exerciseName);
}
