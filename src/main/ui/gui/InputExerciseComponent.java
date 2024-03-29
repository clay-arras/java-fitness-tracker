package ui.gui;

import model.Exercise;
import ui.tui.ExerciseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class InputExerciseComponent {
    private JPanel panel;
    Exercise inputExercise;

    public InputExerciseComponent() {
        inputExercise = new Exercise("Null", -1, -1, -1);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField exerciseNameField = new JTextField("Name");
        JTextField exerciseSetsField = new JTextField("Sets");
        JTextField exerciseRepsField = new JTextField("Reps");
        JTextField exerciseWeightField = new JTextField("Weight");

        exerciseNameField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseNameField.getText();
                inputExercise.setExerciseName(textFieldValue);
                System.out.println("SET TO " + textFieldValue);
                ExerciseHandler exerciseHandler = new ExerciseHandler();
                exerciseHandler.displayExercise(inputExercise);
                System.out.println(this);
            }
        });
        exerciseSetsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseSetsField.getText();
                inputExercise.setExerciseSets(Integer.valueOf(textFieldValue));
                System.out.println("SET TO " + textFieldValue);
            }
        });
        exerciseRepsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseRepsField.getText();
                inputExercise.setExerciseReps(Integer.valueOf(textFieldValue));
                System.out.println("SET TO " + textFieldValue);
            }
        });
        exerciseWeightField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseWeightField.getText();
                inputExercise.setExerciseWeight(Integer.valueOf(textFieldValue));
                System.out.println("SET TO " + textFieldValue);
            }
        });

        panel.add(exerciseNameField);
        panel.add(exerciseSetsField);
        panel.add(exerciseRepsField);
        panel.add(exerciseWeightField);
    }

    public InputExerciseComponent(Exercise e) {
        inputExercise = new Exercise("Null", -1, -1, -1);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField exerciseNameField = new JTextField(e.getExerciseName());
        JTextField exerciseSetsField = new JTextField(e.getExerciseSets());
        JTextField exerciseRepsField = new JTextField(e.getExerciseReps());
        JTextField exerciseWeightField = new JTextField(e.getExerciseWeight());

        exerciseNameField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseNameField.getText();
                inputExercise.setExerciseName(textFieldValue);
            }
        });
        exerciseSetsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseSetsField.getText();
                inputExercise.setExerciseSets(Integer.valueOf(textFieldValue));
            }
        });
        exerciseRepsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseRepsField.getText();
                inputExercise.setExerciseReps(Integer.valueOf(textFieldValue));
            }
        });
        exerciseWeightField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String textFieldValue = exerciseWeightField.getText();
                inputExercise.setExerciseWeight(Integer.valueOf(textFieldValue));
            }
        });

        panel.add(exerciseNameField);
        panel.add(exerciseSetsField);
        panel.add(exerciseRepsField);
        panel.add(exerciseWeightField);

        e = inputExercise;
    }

    public Exercise getInputExercise() {
        System.out.println(this);
        System.out.println("THIS IS WHAT IS RETURNED");
        ExerciseHandler exerciseHandler = new ExerciseHandler();
        exerciseHandler.displayExercise(inputExercise);
        return inputExercise;
    }

    public JPanel getPanel() {
        return panel;
    }
}
