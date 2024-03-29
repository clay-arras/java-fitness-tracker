package ui.gui;

import model.Tracker;

import javax.swing.*;

/*
Main screen for the edit workout screen
 */
public class EditWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    private JPanel panel;
    private RenderTrackerComponent renderTrackerComponent;

    /*
    MODIFIES: this
    EFFECTS: constructs the screen and adds components
     */
    public EditWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        panel = new JPanel();
        renderTrackerComponent = new RenderTrackerComponent(t);

        panel.add(backButton);
        panel.add(renderTrackerComponent.getPanel());
    }

    /*
    MODIFIES: this.panel
    EFFECTS: updates the UI screen
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
