package ui.gui;

import model.Tracker;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tui.WorkoutHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import static ui.gui.GUIApplication.JSON_STORE;

/*
Container for the titleComponent
 */
public class MenuScreen extends JPanel {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the panel
     */
    public MenuScreen(JButton saveWorkoutButton, JButton loadWorkoutButton, JButton viewWorkoutButton, JButton removeWorkoutButton, JButton editWorkoutButton, JButton addWorkoutButton, JButton viewMetricsButton) {
        panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);
        TitleComponent titleComponent = null;
        try {
            titleComponent = new TitleComponent();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        panel.add(titleComponent.getLabel());
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(addWorkoutButton);
        container.add(removeWorkoutButton);
        container.add(editWorkoutButton);
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
