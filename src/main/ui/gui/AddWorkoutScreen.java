package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Main screen for adding workouts
 */
public class AddWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    private JPanel panel;
    private Workout inputWorkout;
    private InputWorkoutComponent inputWorkoutComponent;
    private Tracker tracker;
    private GUIApplication guiApplication;
    private JButton submitButton;

    /*
    MODIFIES: this
    EFFECTS: constructs the adding screen
     */
    public AddWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        this.guiApplication = guiApplication;
        inputWorkoutComponent = new InputWorkoutComponent(this);
        panel = new JPanel();

        tracker = t;
        submitButton = initializeSubmitButton();

        panel.add(backButton);
        panel.add(inputWorkoutComponent.getPanel());
        panel.add(submitButton);
    }

    /*
    MODIFIES: this.panel
    EFFECTS: updates the panel
     */
    public void update(Tracker tracker) {
        panel.remove(inputWorkoutComponent.getPanel());
        panel.add(inputWorkoutComponent.getPanel());
        panel.revalidate();
        panel.repaint();
        this.tracker = tracker;
    }

    /*
    MODIFIES: this.panel
    EFFECTS: updates the panel
     */
    public void update() {
        panel.remove(inputWorkoutComponent.getPanel());
        panel.add(inputWorkoutComponent.getPanel());
        panel.revalidate();
        panel.repaint();
    }

    /*
    MODIFIES: this.tracker
    EFFECTS: initializes a submit button to update tracker
     */
    public JButton initializeSubmitButton() {
        JButton submitButton = new JButton("Add workout");
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputWorkout = inputWorkoutComponent.getInputWorkout();
                tracker.addWorkout(inputWorkout);
                ImageIcon image = new ImageIcon("assets/image.png");
                JOptionPane.showMessageDialog(panel, "Workout added!", "Success", JOptionPane.INFORMATION_MESSAGE, image);
                guiApplication.updateAllScreens();

//                System.out.println("TRACKER IN WORKOUT SCREEN");
//                TrackerHandler trackerHandler = new TrackerHandler(tracker);
//                trackerHandler.displayWorkouts();
            }
        });
        return submitButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}
