package persistence;

import model.Tracker;
import model.Exercise;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/*
Tests for the JSONReader class
Citation: All tests were adapted from Felix code
 */
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Tracker t = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTracker() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTracker.json");
        try {
            Tracker t = reader.read();
            assertEquals(0, t.getNumWorkouts());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTracker() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTracker.json");
        try {
            Tracker t = reader.read();
            assertEquals(t.getNumWorkouts(), 2);
            Exercise e1 = t.getWorkout(0).getExercise(0);
            Exercise e2 = t.getWorkout(0).getExercise(1);
            Exercise e3 = t.getWorkout(1).getExercise(0);

            checkExercise("Bicep Curls", 11, 4, 30, e1);
            checkExercise("Leg Extensions", 11, 3, 105, e2);
            checkExercise("Bench Press", 10, 4, 120, e3);

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}