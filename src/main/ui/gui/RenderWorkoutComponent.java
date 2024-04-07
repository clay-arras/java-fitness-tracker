package ui.gui;

import model.Exercise;
import model.Workout;

import javax.swing.*;

public class RenderWorkoutComponent extends JPanel {
    static JPanel panel;

    public RenderWorkoutComponent(Workout w) {
        panel = new JPanel();

        panel.add(new JLabel("WORKOUT:"));
        for (int exerciseIndex = 0; exerciseIndex < w.getNumExercise(); exerciseIndex++) {
            panel.add(new JLabel("Exercise number: " + (exerciseIndex + 1)));
            panel.add(new JLabel("---"));
            Exercise e = w.getExercise(exerciseIndex);
            RenderExerciseComponent renderExerciseComponent = new RenderExerciseComponent(e);
            panel.add(renderExerciseComponent.getPanel());
            panel.add(new JLabel("\n"));
        }
    }

    public static JPanel getPanel() {
        return panel;
    }
}
