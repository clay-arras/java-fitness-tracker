package ui.gui;

import model.Tracker;
import model.Workout;

import javax.swing.*;

/*
This class is for rendering renderWorkoutComponents
 */
public class RenderTrackerComponent {
    private final JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: constructs a component that renders RenderWorkoutComponents
     */
    public RenderTrackerComponent(Tracker t) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int workoutIndex = 0; workoutIndex < t.getNumWorkouts(); workoutIndex++) {
            Workout w = t.getWorkout(workoutIndex);
            RenderWorkoutComponent renderWorkoutComponent = new RenderWorkoutComponent(w);
            panel.add(RenderWorkoutComponent.getPanel());
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
