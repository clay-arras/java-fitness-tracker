package ui.gui;

import model.Tracker;
import model.Workout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Main screen for adding workouts
 */
public class AddWorkoutScreen {
    private final int height = 600;
    private final int width = 400;
    private final JPanel panel;
    private final InputWorkoutComponent inputWorkoutComponent;
    private final GraphicApplication graphicApplication;
    private final JButton submitButton;
    private Workout inputWorkout;
    private Tracker tracker;

    /*
    MODIFIES: this
    EFFECTS: constructs the adding screen
     */
    public AddWorkoutScreen(JButton backButton, Tracker t, GraphicApplication graphicApplication) {
        this.graphicApplication = graphicApplication;
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
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputWorkout = inputWorkoutComponent.getInputWorkout();
                tracker.addWorkout(inputWorkout);
                ImageIcon image = new ImageIcon("assets/image.png");
                JOptionPane.showMessageDialog(
                        panel,
                        "Workout added!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE,
                        image
                );
                graphicApplication.updateAllScreens();
            }
        });
        return submitButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}
