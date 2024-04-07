package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

import static java.lang.Math.max;

/*
A basic tracker for multiple workouts, that can also find certain relevant metrics
 */
public class Tracker implements Metrics, Writable {
    private final ArrayList<Workout> listOfWorkout;
    private final EventLog logger;

    /*
    MODIFIES: this
    EFFECTS: constructs a new tracker
     */
    public Tracker() {
        listOfWorkout = new ArrayList<>();
        logger = EventLog.getInstance();
        logger.logEvent(new Event("Initialized tracker"));
    }

    /*
    MODIFIES: listOfWorkout
    EFFECTS: adds a new workout
     */
    public void addWorkout(Workout newWorkout) {
        listOfWorkout.add(newWorkout);
        logger.logEvent(new Event("Added workout to tracker"));
    }

    /*
    REQUIRES: index < listOfWorkout.size()
    MODIFIES: listOfWorkout
    EFFECTS: removes a workout
    */
    public void removeWorkout(int index) {
        listOfWorkout.remove(index);
        logger.logEvent(new Event("Removed workout at index " + index + " from tracker"));
    }

    /*
    REQUIRES: index < listOfWorkout.size()
    MODIFIES: listOfWorkout
    EFFECTS: edits a workout
    */
    public void editWorkout(int index, Workout newWorkout) {
        listOfWorkout.set(index, newWorkout);
        logger.logEvent(new Event("Edited workout at index " + index + " in tracker"));
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
        logger.logEvent(new Event("Fetched " + exerciseName + "'s volume from tracker with value of " + maxVolume));
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
        logger.logEvent(new Event("Fetched " + exerciseName + "'s 1RM from tracker with value of " + max1RM));
        return max1RM;
    }

    /*
    EFFECTS: returns a JSON object
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfWorkout", workoutsToJson());
        return json;
    }

    /*
    EFFECTS: converts exercises to Json
     */
    public JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : listOfWorkout) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }
}
