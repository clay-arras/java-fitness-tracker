package ui.gui;

import model.Exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
This class handles inputting a single exercise
 */
public class InputExerciseComponent {
    private final JPanel panel;
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
        initializeExerciseNameField();
        initializeExerciseRepsField();
        initializeExerciseSetsField();
        initializeExerciseWeightField();
    }

    /*
    EFFECTS: initializes exerciseNameField
     */
    private void initializeExerciseNameField() {
        exerciseNameField = new JTextField("Name");
        exerciseNameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputExercise.setExerciseName(exerciseNameField.getText());
            }
        });
    }

    /*
    EFFECTS: initializes exerciseSetsField
     */
    private void initializeExerciseSetsField() {
        exerciseSetsField = new JTextField("Sets");
        exerciseSetsField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputExercise.setExerciseSets(Integer.valueOf(exerciseSetsField.getText()));
            }
        });
    }

    /*
    EFFECTS: initializes exerciseRepsField
     */
    private void initializeExerciseRepsField() {
        exerciseRepsField = new JTextField("Reps");
        exerciseRepsField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputExercise.setExerciseReps(Integer.valueOf(exerciseRepsField.getText()));
            }
        });
    }

    /*
    EFFECTS: initializes exerciseWeightField
     */
    private void initializeExerciseWeightField() {
        exerciseWeightField = new JTextField("Weight");
        exerciseWeightField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
