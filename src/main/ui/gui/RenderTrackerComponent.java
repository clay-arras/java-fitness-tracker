package ui.gui;

import model.Tracker;
import model.Workout;

import javax.swing.*;

public class RenderTrackerComponent {
    static JPanel panel;

    public RenderTrackerComponent(Tracker t) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int workoutIndex = 0; workoutIndex < t.getNumWorkouts(); workoutIndex++) {
            Workout w = t.getWorkout(workoutIndex);
            RenderWorkoutComponent renderWorkoutComponent = new RenderWorkoutComponent(w);
            panel.add(renderWorkoutComponent.getPanel());
        }
    }

    public static JPanel getPanel() {
        return panel;
    }
}
