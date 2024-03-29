package ui.gui;

import model.Workout;
import model.Exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputWorkoutComponent {
    static JPanel panel;
    static JPanel listOfExercisePanel;
    Workout inputWorkout;
    JTextField numExercisesTextField;
    int numExercises;

    public InputWorkoutComponent(AddWorkoutScreen addWorkoutScreen) {
        panel = new JPanel();
        listOfExercisePanel = new JPanel();
//        InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
//        panel.add(inputExerciseComponent.getPanel());

        numExercisesTextField = new JTextField("0");
        numExercisesTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = numExercisesTextField.getText();
                numExercises = Integer.valueOf(textFieldValue);
                System.out.println("Number of exercises: " + numExercises);
                // update panel
                // for all input in panel, remove then re-add numExercises
                for (Component c : listOfExercisePanel.getComponents()) {
                    listOfExercisePanel.remove(c);
                }
                for (int i = 0; i < numExercises; i++) {
                    InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
                    listOfExercisePanel.add(inputExerciseComponent.getPanel());
                }
                addWorkoutScreen.update();
                panel.revalidate();
                panel.repaint();
            }
        });

        panel.add(numExercisesTextField);
        panel.add(listOfExercisePanel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public Workout getInputWorkout() {
        inputWorkout = new Workout();
        for (Component c : listOfExercisePanel.getComponents()) {
            Exercise e = ((InputExerciseComponent)c).getInputExercise();
            inputWorkout.addExercise(e);
        }
        return inputWorkout;
    }
}
