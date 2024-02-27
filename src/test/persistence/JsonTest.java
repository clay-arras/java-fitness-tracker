package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Exercise;

public class JsonTest {
    protected void checkExercise(
            String exerciseName, int exerciseReps, int exerciseSets, int exerciseWeight, Exercise e) {

        assertEquals(e.getExerciseName(), exerciseName);
        assertEquals(e.getExerciseReps(), exerciseReps);
        assertEquals(e.getExerciseSets(), exerciseSets);
        assertEquals(e.getExerciseWeight(), exerciseWeight);
    }
}
