package ui.gui;

import model.Tracker;
import ui.tui.TrackerHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
This class handles removing exercises
 */
public class RemoveWorkoutScreen {
    private final int height = 600;
    private final int width = 400;
    private final JPanel panel;
    private final JScrollPane scrollPane;
    private final JTextField removeWorkoutTextField;
    private RenderTrackerComponent renderTrackerComponent;
    private Tracker tracker;
    private JPanel renderTrackerPanel;

    /*
    MODIFIES: this
    EFFECTS: initializes remove workout screen
     */
    public RemoveWorkoutScreen(JButton backButton, Tracker t, GraphicApplication graphicApplication) {
        panel = new JPanel();
        scrollPane = new JScrollPane();
        tracker = t;
        renderTrackerComponent = new RenderTrackerComponent(tracker);
        renderTrackerPanel = renderTrackerComponent.getPanel();
        removeWorkoutTextField = getRemoveWorkoutTextField(t, graphicApplication);

        panel.add(backButton);
        panel.add(renderTrackerPanel);
        panel.add(removeWorkoutTextField);
    }

    /*
    MODIFIES: this.removeWorkoutTextField
    EFFECTS: constructs removeWorkoutTextField
     */
    private JTextField getRemoveWorkoutTextField(Tracker t, GraphicApplication graphicApplication) {
        JTextField removeWorkoutTextField = new JTextField("Index");
        removeWorkoutTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    TrackerHandler trackerHandler = new TrackerHandler(t);
                    trackerHandler.displayWorkouts();
                    int textFieldNumber = Integer.valueOf(removeWorkoutTextField.getText());
                    tracker.removeWorkout(textFieldNumber);
                    graphicApplication.updateAllScreens();
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
