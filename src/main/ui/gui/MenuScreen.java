package ui.gui;

import javax.swing.*;

/*
Container for the titleComponent
 */
public class MenuScreen extends JPanel {
    static JPanel panel;
    private final int height = 600;
    private final int width = 400;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the panel
     */
    public MenuScreen(JButton saveWorkoutButton, JButton loadWorkoutButton,
                      JButton viewWorkoutButton, JButton removeWorkoutButton,
                      JButton editWorkoutButton, JButton addWorkoutButton,
                      JButton viewMetricsButton) {
        panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);
        TitleComponent titleComponent = new TitleComponent();
        panel.add(titleComponent.getLabel());
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(addWorkoutButton);
        container.add(removeWorkoutButton);
        container.add(viewWorkoutButton);
        container.add(viewMetricsButton);
        container.add(saveWorkoutButton);
        container.add(loadWorkoutButton);

        panel.add(container);
    }

    public static JPanel getPanel() {
        return panel;
    }
}
