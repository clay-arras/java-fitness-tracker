package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;
    static JScrollPane scrollPane;
    static Workout inputWorkout;
    static InputWorkoutComponent inputWorkoutComponent;
    static Tracker tracker;

    static JButton submitButton;

    public AddWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        panel = new JPanel();
        scrollPane = new JScrollPane();
        inputWorkoutComponent = new InputWorkoutComponent(this);

        tracker = t;
        submitButton = initializeSubmitButton();

//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(backButton);
        panel.add(inputWorkoutComponent.getPanel());
        panel.add(submitButton);
    }

    public static JPanel getPanel() {
        return panel;
    }

    public void update() {
        panel.remove(inputWorkoutComponent.getPanel());
        panel.add(inputWorkoutComponent.getPanel());
        panel.revalidate();
        panel.repaint();
//        t.addWorkout(inputWorkout);
    }

    public JButton initializeSubmitButton() {
        JButton submitButton = new JButton("Add workout");
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputWorkout = inputWorkoutComponent.getInputWorkout();
                tracker.addWorkout(inputWorkout);
                System.out.println("Workout submitted");
            }
        });
        return submitButton;
    }
}
