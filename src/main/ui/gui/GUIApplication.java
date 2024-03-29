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
import java.net.MalformedURLException;
import java.net.URL;

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
    JButton viewMetricsButton;
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

        buttonInitialization();
        addScreensToPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /*
    MODIFIES: all screens && this.panel
    EFFECTS: initializes all the screens and adds them to panel
     */
    private void addScreensToPanel() {
//        screenInitialization();
        menuScreen = new MenuScreen(saveWorkoutButton, loadWorkoutButton, viewWorkoutButton, removeWorkoutButton,
            editWorkoutButton, addWorkoutButton, viewMetricsButton);
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
    }

//    /*
//    MODIFIES: all screens
//    EFFECTS: initializes all the screens
//     */
//    private void screenInitialization() {
//        menuScreen = new MenuScreen(saveWorkoutButton, loadWorkoutButton, viewWorkoutButton, removeWorkoutButton,
//                editWorkoutButton, addWorkoutButton, viewMetricsButton);
//        viewWorkoutScreen = new ViewWorkoutScreen(initializeBackButton(), tracker);
//        removeWorkoutScreen = new RemoveWorkoutScreen(initializeBackButton(), tracker, this);
//        editWorkoutScreen = new EditWorkoutScreen(initializeBackButton(), tracker, this);
//        addWorkoutScreen = new AddWorkoutScreen(initializeBackButton(), tracker, this);
//    }

    /*
    MODIFIES: all buttons
    EFFECTS: initializes all the buttons
     */
    private void buttonInitialization() {
        saveWorkoutButton = initializeSaveWorkoutButton();
        loadWorkoutButton = initializeLoadWorkoutButton();
        viewWorkoutButton = initializeViewWorkoutButton();
        removeWorkoutButton = initializeRemoveWorkoutButton();
        editWorkoutButton = initializeEditWorkoutButton();
        addWorkoutButton = initializeAddWorkoutButton();
        backButton = initializeBackButton();
        viewMetricsButton = initializeViewMetricsButton();
    }

    /*
    EFFECTS: makes a new button for going back
     */
    private JButton initializeBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Back button pressed");
                layout.show(panel, MENU_SCREEN);

                updateAllScreens();
//                addScreensToPanel();
//                screenInitialization();

//                System.out.println("TRACKER IN GUI");
//                TrackerHandler trackerHandler = new TrackerHandler(tracker);
//                trackerHandler.displayWorkouts();
            }
        });
        return backButton;
    }

    /*
    EFFECTS: makes a new button for saving workouts
     */
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

    /*
    EFFECTS: makes a new button for loading workouts
     */
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

    /*
    EFFECTS: makes a new button for viewing workouts
     */
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

    /*
    EFFECTS: makes a new button for remove workouts
     */
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

    /*
    EFFECTS: makes a new button for editing workouts
     */
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

    /*
    EFFECTS: makes a new button for adding workouts
     */
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

    /*
    EFFECTS: makes a new button for metrics
     */
    private JButton initializeViewMetricsButton() {
        JButton addWorkoutButton = new JButton("View metrics");
        addWorkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImageIcon image = new ImageIcon("assets/image.png");
                String s = (String)JOptionPane.showInputDialog(frame, "Which exercise? ");

                JOptionPane.showMessageDialog(frame,
                        "Highest volume: " + tracker.findMaxVolume(s)
                               + "\nHighest 1RM: " + tracker.findMax1RM(s),
                        "Metrics",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return addWorkoutButton;
    }

    /*
    EFFECTS: updates all the screens in the application
     */
    protected void updateAllScreens() {
        System.out.println("Updating screens");
        viewWorkoutScreen.update(tracker);
        removeWorkoutScreen.update(tracker);
        editWorkoutScreen.update(tracker);
        addWorkoutScreen.update(tracker);
        frame.revalidate();
        frame.repaint();
    }
}
