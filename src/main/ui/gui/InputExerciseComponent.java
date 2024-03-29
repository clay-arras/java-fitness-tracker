package ui.gui;

import model.Exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InputExerciseComponent extends JPanel {
    static JPanel panel;
    Exercise inputExercise;

    public InputExerciseComponent() {
        Exercise inputExercise = new Exercise("Null", -1, -1, -1);
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
    }

    public InputExerciseComponent(Exercise e) {
        Exercise inputExercise = new Exercise("Null", -1, -1, -1);
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
        return inputExercise;
    }

    public JPanel getPanel() {
        return panel;
    }
}
