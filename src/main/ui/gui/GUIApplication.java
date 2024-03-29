package ui.gui;

import model.Tracker;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tui.TrackerHandler;

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
    String currentScreen;

    MenuScreen menuScreen;
    AddWorkoutScreen addWorkoutScreen;
    RemoveWorkoutScreen removeWorkoutScreen;
    ViewWorkoutScreen viewWorkoutScreen;
    EditWorkoutScreen editWorkoutScreen;

    JButton saveWorkoutButton;
    JButton loadWorkoutButton;
    JButton viewWorkoutButton;
    JButton removeWorkoutButton;
    JButton editWorkoutButton;
    JButton addWorkoutButton;
    JButton backButton;

    CardLayout layout;
    JPanel panel;

    private final String MENU_SCREEN = "MENU_SCREEN";
    private final String VIEW_WORKOUT_SCREEN = "VIEW_WORKOUT_SCREEN";
    private final String EDIT_WORKOUT_SCREEN = "EDIT_WORKOUT_SCREEN";
    private final String ADD_WORKOUT_SCREEN = "ADD_WORKOUT_SCREEN";
    private final String REMOVE_WORKOUT_SCREEN = "REMOVE_WORKOUT_SCREEN";

    /*
    MODIFIES: this
    EFFECTS: main runner for the application
     */
    public GUIApplication() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        tracker = new Tracker();
        frame = new JFrame();
        layout = new CardLayout();
        panel = new JPanel();

        saveWorkoutButton = initializeSaveWorkoutButton();
        loadWorkoutButton = initializeLoadWorkoutButton();
        viewWorkoutButton = initializeViewWorkoutButton();
        removeWorkoutButton = initializeRemoveWorkoutButton();
        editWorkoutButton = initializeEditWorkoutButton();
        addWorkoutButton = initializeAddWorkoutButton();
        backButton = initializeBackButton();

        menuScreen = new MenuScreen(saveWorkoutButton, loadWorkoutButton, viewWorkoutButton, removeWorkoutButton, editWorkoutButton, addWorkoutButton);
        viewWorkoutScreen = new ViewWorkoutScreen(initializeBackButton(), tracker);
        removeWorkoutScreen = new RemoveWorkoutScreen(initializeBackButton(), tracker, this);
        editWorkoutScreen = new EditWorkoutScreen(initializeBackButton(), tracker, this);
        addWorkoutScreen = new AddWorkoutScreen(initializeBackButton(), tracker, this);

        panel.setLayout(layout);
        panel.add(menuScreen.getPanel(), MENU_SCREEN);
        panel.add(viewWorkoutScreen.getPanel(), VIEW_WORKOUT_SCREEN);
        panel.add(removeWorkoutScreen.getPanel(), REMOVE_WORKOUT_SCREEN);
        panel.add(editWorkoutScreen.getPanel(), EDIT_WORKOUT_SCREEN);
        panel.add(addWorkoutScreen.getPanel(), ADD_WORKOUT_SCREEN);
        currentScreen = MENU_SCREEN;

        frame.add(panel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private JButton initializeBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                TrackerHandler trackerHandler = new TrackerHandler(tracker);
//                trackerHandler.displayWorkouts();
                System.out.println("Back button pressed");
                layout.show(panel, MENU_SCREEN);
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
                    updateAllScreens();
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
                layout.show(panel, VIEW_WORKOUT_SCREEN);
                currentScreen = VIEW_WORKOUT_SCREEN;
            }
        });
        return viewWorkoutButton;
    }

    private JButton initializeRemoveWorkoutButton() {
        JButton removeWorkoutButton = new JButton("Remove workouts");
        removeWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Changing to remove workout screen");
                layout.show(panel, REMOVE_WORKOUT_SCREEN);
                currentScreen = REMOVE_WORKOUT_SCREEN;
            }
        });
        return removeWorkoutButton;
    }

    private JButton initializeEditWorkoutButton() {
        JButton editWorkoutButton = new JButton("Edit workouts");
        editWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Changing to edit workout screen");
                layout.show(panel, EDIT_WORKOUT_SCREEN);
                currentScreen = EDIT_WORKOUT_SCREEN;
            }
        });
        return editWorkoutButton;
    }

    private JButton initializeAddWorkoutButton() {
        JButton addWorkoutButton = new JButton("Add workouts");
        addWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Changing to add workout screen");
                layout.show(panel, ADD_WORKOUT_SCREEN);
                currentScreen = ADD_WORKOUT_SCREEN;
            }
        });
        return addWorkoutButton;
    }

    protected void updateAllScreens() {
        System.out.println("Updating screens");
        viewWorkoutScreen.update(tracker);
        removeWorkoutScreen.update(tracker);
        editWorkoutScreen.update(tracker);
        addWorkoutScreen.update();
        frame.revalidate();
        frame.repaint();
    }
}
