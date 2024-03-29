package ui.gui;

import model.Workout;

import javax.swing.*;

public class ViewWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;

    public ViewWorkoutScreen(Workout w) {
        panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);

        RenderWorkoutComponent renderWorkoutComponent = new RenderWorkoutComponent(w);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.Y_AXIS));
        scrollPane.add(renderWorkoutComponent.getPanel());

        panel.add(scrollPane);
    }

    public static JPanel getPanel() {
        return panel;
    }
}
