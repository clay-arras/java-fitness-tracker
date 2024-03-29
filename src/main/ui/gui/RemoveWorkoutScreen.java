package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;
import ui.tui.ExerciseHandler;
import ui.tui.TrackerHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
This class handles removing exercises
 */
public class RemoveWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    private JPanel panel;
    private JScrollPane scrollPane;
    private RenderTrackerComponent renderTrackerComponent;
    private Tracker tracker;
    private JPanel renderTrackerPanel;
    private JTextField removeWorkoutTextField;

    /*
    MODIFIES: this
    EFFECTS: initializes remove workout screen
     */
    public RemoveWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        panel = new JPanel();
        scrollPane = new JScrollPane();
        tracker = t;
        renderTrackerComponent = new RenderTrackerComponent(tracker);
        renderTrackerPanel = renderTrackerComponent.getPanel();
        removeWorkoutTextField = getRemoveWorkoutTextField(t, guiApplication);

        panel.add(backButton);
        panel.add(renderTrackerPanel);
        panel.add(removeWorkoutTextField);
    }

    /*
    MODIFIES: this.removeWorkoutTextField
    EFFECTS: constructs removeWorkoutTextField
     */
    private JTextField getRemoveWorkoutTextField(Tracker t, GUIApplication guiApplication) {
        JTextField removeWorkoutTextField = new JTextField("Index");
        removeWorkoutTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    TrackerHandler trackerHandler = new TrackerHandler(t);
                    trackerHandler.displayWorkouts();
                    int textFieldNumber = Integer.valueOf(removeWorkoutTextField.getText());
                    tracker.removeWorkout(textFieldNumber);
                    guiApplication.updateAllScreens();
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("Out of bounds");
                }
            }
        });
        return removeWorkoutTextField;
    }

    /*
    EFFECTS: updates the panel
     */
    public void update(Tracker t) {
        tracker = t;
        panel.remove(renderTrackerPanel);
        renderTrackerComponent = new RenderTrackerComponent(tracker);
        renderTrackerPanel = renderTrackerComponent.getPanel();
        panel.add(renderTrackerPanel);
    }

    public JPanel getPanel() {
        return panel;
    }
}
