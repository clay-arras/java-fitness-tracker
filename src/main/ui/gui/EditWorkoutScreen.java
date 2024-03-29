package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;

import javax.swing.*;

public class EditWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;
    static JScrollPane scrollPane;
    static RenderTrackerComponent renderTrackerComponent;

    public EditWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        panel = new JPanel();
        scrollPane = new JScrollPane();
        renderTrackerComponent = new RenderTrackerComponent(t);

//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(backButton);
        panel.add(renderTrackerComponent.getPanel());
//        panel.add(scrollPane);
    }

    public static JPanel getPanel() {
        return panel;
    }

    public void update(Tracker t) {
        panel.remove(renderTrackerComponent.getPanel());
        renderTrackerComponent = new RenderTrackerComponent(t);
        panel.add(renderTrackerComponent.getPanel());
    }
}
