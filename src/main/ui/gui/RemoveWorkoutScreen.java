package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;
import ui.tui.ExerciseHandler;
import ui.tui.TrackerHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;
    static JScrollPane scrollPane;
    static RenderTrackerComponent renderTrackerComponent;
    static Tracker tracker;
    static JPanel renderTrackerPanel;

    public RemoveWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        panel = new JPanel();
        scrollPane = new JScrollPane();
        tracker = t;
        renderTrackerComponent = new RenderTrackerComponent(tracker);
        renderTrackerPanel = renderTrackerComponent.getPanel();

        tracker = t;
        JTextField removeWorkoutTextField = new JTextField("Index");
        removeWorkoutTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    TrackerHandler trackerHandler = new TrackerHandler(t);
                    trackerHandler.displayWorkouts();
                    int textFieldNumber = Integer.valueOf(removeWorkoutTextField.getText());
                    System.out.println("Removing " + textFieldNumber);
                    System.out.println("Total workouts: " + tracker.getNumWorkouts());
                    tracker.removeWorkout(textFieldNumber);
                    guiApplication.updateAllScreens();
                } catch (java.lang.IndexOutOfBoundsException exception) {
                    System.out.println("Out of bounds");
                }
            }
        });

//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(backButton);
        panel.add(renderTrackerPanel);
        panel.add(removeWorkoutTextField);
//        panel.add(scrollPane);

    }

    public static JPanel getPanel() {
        return panel;
    }

    public void update(Tracker t) {
//        TrackerHandler trackerHandler = new TrackerHandler(t);
//        trackerHandler.displayWorkouts();
        tracker = t;
        panel.remove(renderTrackerPanel);
        renderTrackerComponent = new RenderTrackerComponent(tracker);
        renderTrackerPanel = renderTrackerComponent.getPanel();
        panel.add(renderTrackerPanel);
    }
}
