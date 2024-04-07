package ui.gui;

import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
This class handles inputting multiple exercises
 */
public class InputWorkoutComponent {
    private final JPanel panel;
    private final JPanel listOfExercisePanel;
    AddWorkoutScreen addWorkoutScreen;
    ArrayList<InputExerciseComponent> listOfExercise;
    JTextField numExercisesTextField;
    Workout inputWorkout;
    int numExercises;

    /*
    MODIFIES: this
    EFFECTS: creates inputting for a workout by using inputExerciseComponent
     */
    public InputWorkoutComponent(AddWorkoutScreen addWorkoutScreen) {
        this.addWorkoutScreen = addWorkoutScreen;
        panel = new JPanel();
        listOfExercisePanel = new JPanel();
        listOfExercise = new ArrayList<>();
        inputWorkout = new Workout();

        numExercisesTextField = new JTextField("0");
        numExercisesTextField.addActionListener(getTextFieldActionListener());
        panel.add(numExercisesTextField);
        panel.add(listOfExercisePanel);
    }

    /*
    EFFECTS: returns an action listener for the text field
     */
    public ActionListener getTextFieldActionListener() {
        return (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = numExercisesTextField.getText();
                numExercises = Integer.valueOf(textFieldValue);
                for (Component c : listOfExercisePanel.getComponents()) {
                    listOfExercisePanel.remove(c);
                }
                listOfExercise.clear();
                for (int i = 0; i < numExercises; i++) {
                    InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
                    listOfExercisePanel.add(inputExerciseComponent.getPanel());
                    listOfExercise.add(inputExerciseComponent);
                }
                addWorkoutScreen.update();
                panel.revalidate();
                panel.repaint();
            }
        });
    }

    /*
    EFFECTS: getter for inputWorkouts, constructs it from ArrayList
     */
    public Workout getInputWorkout() {
        inputWorkout = new Workout();
        for (InputExerciseComponent inputExerciseComponent : listOfExercise) {
            inputWorkout.addExercise(inputExerciseComponent.getInputExercise());
        }
        return inputWorkout;
    }

    public JPanel getPanel() {
        return panel;
    }
}
