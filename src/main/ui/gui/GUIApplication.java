package ui.gui;

import model.Tracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Main component for the GUI application
 */
public class GUIApplication extends JFrame {
    private final int HEIGHT = 1000;
    private final int WIDTH = 1400;
    static JFrame frame;
    protected Tracker tracker;

    protected static final String JSON_STORE = "./data/userData.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    JComponent currentScreen;

    MenuScreen menuScreen;
    AddWorkoutScreen addWorkoutScreen;
    RemoveWorkoutScreen removeWorkoutScreen;
    ViewWorkoutScreen viewWorkoutScreen;
    EditWorkoutScreen editWorkoutScreen;

    /*
    MODIFIES: this
    EFFECTS: main runner for the application
     */
    public GUIApplication() {
        tracker = new Tracker();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        frame = new JFrame();

        JButton saveWorkoutButton = initializeSaveWorkoutButton();
        JButton loadWorkoutButton = initializeLoadWorkoutButton();
        JButton viewWorkoutButton = initializeViewWorkoutButton();

        menuScreen = new MenuScreen(saveWorkoutButton, loadWorkoutButton, viewWorkoutButton);
        viewWorkoutScreen = new ViewWorkoutScreen(tracker);

        frame.add(menuScreen.getPanel());
        currentScreen = menuScreen.getPanel();

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private JButton initializeBackButton() {
        JButton backButton = new JButton("GO BACK");
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Back button pressed");
                frame.remove(currentScreen);
                frame.add(menuScreen.getPanel());
            }
        });
        return backButton;
    }

    private JButton initializeSaveWorkoutButton() {
        JButton saveWorkoutButton = new JButton("Save workouts");
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
        return saveWorkoutButton;
    }

    private JButton initializeLoadWorkoutButton() {
        JButton loadWorkoutButton = new JButton("Load workouts");
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
        return loadWorkoutButton;
    }

    private JButton initializeViewWorkoutButton() {
        JButton viewWorkoutButton = new JButton("View workouts");
        viewWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Changing to view workout screen");
                frame.remove(currentScreen);
                frame.add(viewWorkoutScreen.getPanel());
                currentScreen = viewWorkoutScreen.getPanel();
            }
        });
        return viewWorkoutButton;
    }
}
