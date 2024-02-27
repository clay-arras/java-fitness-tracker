package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Exercise;
import model.Tracker;
import model.Workout;
import org.json.*;

/*
Represents a reader that reads workroom from JSON data stored in file
Citation: adapted from Felix
 */
public class JsonReader {
    private final String source;

    /*
    EFFECTS: constructs reader to read from source file
     */
    public JsonReader(String source) {
        this.source = source;
    }

    /*
    EFFECTS: reads workroom from file and returns it; throws IOException if an error occurs reading data from file
     */
    public Tracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTracker(jsonObject);
    }

    /*
    EFFECTS: reads source file as string and returns it
     */
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    /*
    EFFECTS: parses tracker from JSON object and returns it
     */
    private Tracker parseTracker(JSONObject jsonObject) {
        Tracker t = new Tracker();
        JSONArray jsonArray = jsonObject.getJSONArray("listOfWorkout");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(t, nextWorkout);
        }
        return t;
    }

    /*
    MODIFIES: w
    EFFECTS: parses exercises from JSON object and adds them to w
     */
    private void addWorkout(Tracker t, JSONObject jsonObject) {
        Workout w = new Workout();
        JSONArray jsonArray = jsonObject.getJSONArray("listOfExercise");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(w, nextExercise);
        }
        t.addWorkout(w);
    }

    /*
    MODIFIES: w
    EFFECTS: parses an exercise from JSON object
     */
    private void addExercise(Workout w, JSONObject jsonObject) {
        String exerciseName = jsonObject.getString("exerciseName");
        int exerciseReps = jsonObject.getInt("exerciseReps");
        int exerciseSets = jsonObject.getInt("exerciseSets");
        int exerciseWeight = jsonObject.getInt("exerciseWeight");
        Exercise e = new Exercise(exerciseName, exerciseReps, exerciseSets, exerciseWeight);
        w.addExercise(e);
    }
}
