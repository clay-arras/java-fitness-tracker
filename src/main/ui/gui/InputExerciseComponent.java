package ui.gui;

import model.Exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
This class handles inputting a single exercise
 */
public class InputExerciseComponent {
    private JPanel panel;
    Exercise inputExercise;
    JTextField exerciseNameField;
    JTextField exerciseSetsField;
    JTextField exerciseRepsField;
    JTextField exerciseWeightField;

    /*
    MODIFIES: this
    EFFECTS: initializes inputs for exercises
     */
    public InputExerciseComponent() {
        inputExercise = new Exercise("Null", -1, -1, -1);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        initializeTextFields();
        panel.add(exerciseNameField);
        panel.add(exerciseSetsField);
        panel.add(exerciseRepsField);
        panel.add(exerciseWeightField);
    }

    /*
    MODIFIES: all textFields
    EFFECTS: initializes all text fields and their handlers
     */
    private void initializeTextFields() {
        exerciseNameField = new JTextField("Name");
        exerciseSetsField = new JTextField("Sets");
        exerciseRepsField = new JTextField("Reps");
        exerciseWeightField = new JTextField("Weight");
        exerciseNameField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputExercise.setExerciseName(exerciseNameField.getText());
            }
        });
        exerciseSetsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputExercise.setExerciseSets(Integer.valueOf(exerciseSetsField.getText()));
            }
        });
        exerciseRepsField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputExercise.setExerciseReps(Integer.valueOf(exerciseRepsField.getText()));
            }
        });
        exerciseWeightField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputExercise.setExerciseWeight(Integer.valueOf(exerciseWeightField.getText()));
            }
        });
    }

    public Exercise getInputExercise() {
        return inputExercise;
    }

    public JPanel getPanel() {
        return panel;
    }
}
