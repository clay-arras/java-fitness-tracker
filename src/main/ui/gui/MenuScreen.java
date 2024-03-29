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

/*
Container for the titleComponent
 */
public class MenuScreen extends JPanel {
    private static final String JSON_STORE = "./data/userData.json";
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    Tracker tracker;
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the panel
     */
    public MenuScreen() {
        tracker = new Tracker();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

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

        JButton addWorkoutButton = new JButton("Add workouts");
        JButton removeWorkoutButton = new JButton("Remove workouts");
        JButton editWorkoutButton = new JButton("Edit workouts");
        JButton viewWorkoutButton = new JButton("View workouts");
        JButton saveWorkoutButton = new JButton("Save workouts");
        JButton loadWorkoutButton = new JButton("Load workouts");

        saveWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    jsonWriter.open();
                    jsonWriter.write(tracker);
                    jsonWriter.close();
                    System.out.println("Saved file to " + JSON_STORE);
                } catch (FileNotFoundException exception) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
        loadWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    tracker = jsonReader.read();
                    System.out.println("Loaded file from " + JSON_STORE);
                } catch (IOException exception) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });

        container.add(addWorkoutButton);
        container.add(removeWorkoutButton);
        container.add(editWorkoutButton);
        container.add(viewWorkoutButton);
        container.add(saveWorkoutButton);
        container.add(loadWorkoutButton);

        panel.add(container);
    }

    public static JPanel getPanel() {
        return panel;
    }
}
