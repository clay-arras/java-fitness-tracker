package ui.gui;

import model.Workout;
import model.Exercise;
import ui.tui.ExerciseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputWorkoutComponent {
    private JPanel panel;
    private JPanel listOfExercisePanel;
    Workout inputWorkout;
    JTextField numExercisesTextField;
    int numExercises;
    ArrayList<InputExerciseComponent> listOfExercise;

    public InputWorkoutComponent(AddWorkoutScreen addWorkoutScreen) {
        panel = new JPanel();
        listOfExercisePanel = new JPanel();
//        InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
//        panel.add(inputExerciseComponent.getPanel());
        listOfExercise = new ArrayList<>();
        inputWorkout = new Workout();

        numExercises = 1;
        for (int i = 0; i < numExercises; i++) {
            InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
            listOfExercise.add(inputExerciseComponent);
            System.out.println(inputExerciseComponent);
            listOfExercisePanel.add(inputExerciseComponent.getPanel());
        }
//        numExercisesTextField = new JTextField("0");
//        numExercisesTextField.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                String textFieldValue = numExercisesTextField.getText();
//                numExercises = Integer.valueOf(textFieldValue);
//                System.out.println("Number of exercises: " + numExercises);
//                // update panel
//                // for all input in panel, remove then re-add numExercises
//                for (Component c : listOfExercisePanel.getComponents()) {
//                    listOfExercisePanel.remove(c);
//                }
//                listOfExercise.clear();
//                for (int i = 0; i < numExercises; i++) {
//                    InputExerciseComponent inputExerciseComponent = new InputExerciseComponent();
//                    listOfExercisePanel.add(inputExerciseComponent.getPanel());
//                    listOfExercise.add(inputExerciseComponent);
//                }
//                addWorkoutScreen.update();
//                panel.revalidate();
//                panel.repaint();
//            }
//        });

//        panel.add(numExercisesTextField);
        panel.add(listOfExercisePanel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public Workout getInputWorkout() {
        inputWorkout = new Workout();
        for (InputExerciseComponent inputExerciseComponent : listOfExercise) {
            System.out.println("INPUT WORKOUTS");
            System.out.println(inputExerciseComponent.getInputExercise());
            inputWorkout.addExercise(inputExerciseComponent.getInputExercise());
//            ExerciseHandler exerciseHandler = new ExerciseHandler();
//            exerciseHandler.displayExercise(inputExerciseComponent.getInputExercise());
        }
        return inputWorkout;
    }
}
