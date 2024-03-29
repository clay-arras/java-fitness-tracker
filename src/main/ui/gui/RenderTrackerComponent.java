package ui.gui;

import model.Tracker;
import model.Workout;

import javax.swing.*;

/*
This class is for rendering renderWorkoutComponents
 */
public class RenderTrackerComponent {
    private JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: constructs a component that renders RenderWorkoutComponents
     */
    public RenderTrackerComponent(Tracker t) {
        panel = new JPanel();

        for (int workoutIndex = 0; workoutIndex < t.getNumWorkouts(); workoutIndex++) {
            Workout w = t.getWorkout(workoutIndex);
            RenderWorkoutComponent renderWorkoutComponent = new RenderWorkoutComponent(w);
            panel.add(renderWorkoutComponent.getPanel());
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
