package ui.gui;

import model.Exercise;
import model.Workout;

import javax.swing.*;

public class RenderWorkoutComponent extends JPanel {
    static JPanel panel;

    public RenderWorkoutComponent(Workout w) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int exerciseIndex = 0; exerciseIndex < w.getNumExercise(); exerciseIndex++) {
            Exercise e = w.getExercise(exerciseIndex);
            RenderExerciseComponent renderExerciseComponent = new RenderExerciseComponent(e);
            panel.add(renderExerciseComponent.getPanel());
        }
    }

    public static JPanel getPanel() {
        return panel;
    }
}
