package ui.gui;

import model.Tracker;

import javax.swing.*;

/*
Screen for viewing workouts
 */
public class ViewWorkoutScreen {
    private final int height = 600;
    private final int width = 400;
    private final JPanel panel;
    private RenderTrackerComponent renderTrackerComponent;

    /*
    MODIFIES: this
    EFFECTS: constructs a workout screen
     */
    public ViewWorkoutScreen(JButton backButton, Tracker t) {
        panel = new JPanel();
        renderTrackerComponent = new RenderTrackerComponent(t);

        panel.add(backButton);
        panel.add(renderTrackerComponent.getPanel());
    }

    /*
    EFFECTS: updates the screen
     */
    public void update(Tracker t) {
        panel.remove(renderTrackerComponent.getPanel());
        renderTrackerComponent = new RenderTrackerComponent(t);
        panel.add(renderTrackerComponent.getPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}
