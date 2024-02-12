package model;

/*
Interface for making a workout tracker with certain metrics that you can find
 */
public interface Metrics {
    /*
    EFFECTS: finds the maximum volume among all workouts and exercises with that exercise name
     */
    int findMaxVolume(String exerciseName);

    /*
    EFFECTS: finds the maximum volume among all workouts and exercises with that exercise name
     */
    double findMax1RM(String exerciseName);
}
