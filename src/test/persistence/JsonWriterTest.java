package persistence;

import model.Exercise;
import model.Tracker;
import model.Workout;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Tracker t = new Tracker();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTracker() {
        try {
            Tracker t = new Tracker();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTracker.json");
            writer.open();
            writer.write(t);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTracker.json");
            t = reader.read();

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTracker() {
        try {
            Tracker t = new Tracker();
            Workout w1 = new Workout();
            Workout w2 = new Workout();
            w1.addExercise(new Exercise("Leg Curls", 35, 4, 11));
            w1.addExercise(new Exercise("Hammer Curls", 30, 3, 112));
            w2.addExercise(new Exercise("Push ups", 10, 2, 120));
            t.addWorkout(w1);
            t.addWorkout(w2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTracker.json");
            writer.open();
            writer.write(t);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTracker.json");
            t = reader.read();
            assertEquals(t.getNumWorkouts(), 2);
            Exercise e1 = t.getWorkout(0).getExercise(0);
            Exercise e2 = t.getWorkout(0).getExercise(1);
            Exercise e3 = t.getWorkout(1).getExercise(0);

            checkExercise("Leg Curls", 35, 4, 11, e1);
            checkExercise("Hammer Curls", 30, 3, 112, e2);
            checkExercise("Push ups", 10, 2, 120, e3);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
