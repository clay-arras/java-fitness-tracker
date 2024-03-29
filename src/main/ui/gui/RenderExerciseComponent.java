package ui.gui;

import model.Exercise;

import javax.swing.*;

public class RenderExerciseComponent extends JPanel {
    static JPanel panel;

    public RenderExerciseComponent(Exercise e) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(e.getExerciseName()));
        panel.add(new JLabel("Sets: " + e.getExerciseSets()));
        panel.add(new JLabel("Reps: " + e.getExerciseReps()));
        panel.add(new JLabel("Weight: " + e.getExerciseWeight() + "lbs"));
    }

    public static JPanel getPanel() {
        return panel;
    }
}
