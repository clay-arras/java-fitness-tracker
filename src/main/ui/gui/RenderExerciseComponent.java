package ui.gui;

import model.Exercise;

import javax.swing.*;

/*
This class renders a single exercise panel
 */
public class RenderExerciseComponent {
    private final JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: makes a render exercise given an exercise
     */
    public RenderExerciseComponent(Exercise e) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(e.getExerciseName()));
        panel.add(new JLabel("Sets: " + e.getExerciseSets()));
        panel.add(new JLabel("Reps: " + e.getExerciseReps()));
        panel.add(new JLabel("Weight: " + e.getExerciseWeight() + "lbs"));
    }

    public JPanel getPanel() {
        return panel;
    }
}
