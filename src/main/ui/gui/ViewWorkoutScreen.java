package ui.gui;

import model.Tracker;
import model.Workout;

import javax.swing.*;

public class ViewWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;

    public ViewWorkoutScreen(Tracker t) {
        panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);

        RenderTrackerComponent renderTrackerComponent = new RenderTrackerComponent(t);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(renderTrackerComponent.getPanel());
        panel.add(scrollPane);
    }

    public static JPanel getPanel() {
        return panel;
    }
}
