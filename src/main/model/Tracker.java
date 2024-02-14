package model;

import java.util.ArrayList;

import static java.lang.Math.max;

/*
A basic tracker for multiple workouts, that can also find certain relevant metrics
 */
public class Tracker implements Metrics {
    private final ArrayList<Workout> listOfWorkout;

    /*
    MODIFIES: this
    EFFECTS: constructs a new tracker
     */
    public Tracker() {
        listOfWorkout = new ArrayList<>();
    }

    /*
    MODIFIES: listOfWorkout
    EFFECTS: adds a new workout
     */
    public void addWorkout(Workout newWorkout) {
        listOfWorkout.add(newWorkout);
    }

    /*
    REQUIRES: index < listOfWorkout.size()
    MODIFIES: listOfWorkout
    EFFECTS: removes a workout
    */
    public void removeWorkout(int index) {
        listOfWorkout.remove(index);
    }

    /*
    REQUIRES: index < listOfWorkout.size()
    MODIFIES: listOfWorkout
    EFFECTS: edits a workout
    */
    public void editWorkout(int index, Workout newWorkout) {
        listOfWorkout.set(index, newWorkout);
    }

    /*
    REQUIRES: index < listOfWorkout.size()
    EFFECTS: gets a Workout
    */
    public Workout getWorkout(int index) {
        return listOfWorkout.get(index);
    }

    /*
    EFFECTS: get the length of the tracker
     */
    public int getNumWorkouts() {
        return listOfWorkout.size();
    }

    /*
    EFFECTS: finds the maximum volume among all workouts and exercises with that exercise name
     */
    public int findMaxVolume(String exerciseName) {
        int maxVolume = -1;
        for (Workout workout : listOfWorkout) {
            maxVolume = max(maxVolume, workout.findMaxVolume(exerciseName));
        }
        return maxVolume;
    }

    /*
    EFFECTS: finds the maximum 1RM among all workouts and exercises with that exercise name
     */
    public double findMax1RM(String exerciseName) {
        double max1RM = -1;
        for (Workout workout : listOfWorkout) {
            max1RM = max(max1RM, workout.findMax1RM(exerciseName));
        }
        return max1RM;
    }
}
