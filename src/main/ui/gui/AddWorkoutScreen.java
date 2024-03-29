package ui.gui;

import model.Exercise;
import model.Tracker;
import model.Workout;
import ui.tui.TrackerHandler;
import ui.tui.WorkoutHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class AddWorkoutScreen {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;
    static JScrollPane scrollPane;
    static Workout inputWorkout;
    static InputWorkoutComponent inputWorkoutComponent;
    static Tracker tracker;
    private GUIApplication guiApplication;
    static JButton submitButton;

    public AddWorkoutScreen(JButton backButton, Tracker t, GUIApplication guiApplication) {
        this.guiApplication = guiApplication;
        panel = new JPanel();
        scrollPane = new JScrollPane();
        inputWorkoutComponent = new InputWorkoutComponent(this);

        tracker = t;
        submitButton = initializeSubmitButton();

//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(backButton);
        panel.add(inputWorkoutComponent.getPanel());
        panel.add(submitButton);
    }

    public static JPanel getPanel() {
        return panel;
    }

    public void update() {
        panel.remove(inputWorkoutComponent.getPanel());
        panel.add(inputWorkoutComponent.getPanel());
        panel.revalidate();
        panel.repaint();
//        t.addWorkout(inputWorkout);
    }

    public JButton initializeSubmitButton() {
        JButton submitButton = new JButton("Add workout");
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputWorkout = inputWorkoutComponent.getInputWorkout();
                tracker.addWorkout(inputWorkout);
                System.out.println("Workout submitted");
                String imagePath = "https://pngimg.com/d/dumbbell_PNG16384.png";
                URL imageURL = null;
                try {
                    imageURL = new URL(imagePath);
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
                ImageIcon image = new ImageIcon(imageURL);
                JOptionPane.showMessageDialog(panel, "\nHighest 1RM: ", "Metrics", JOptionPane.INFORMATION_MESSAGE, image);

                guiApplication.updateAllScreens();
                try {
                    TrackerHandler trackerHandler = new TrackerHandler(tracker);
                    trackerHandler.displayWorkouts();
                } catch (Exception exception) {
                    System.out.println("Tracker is null");
                }
            }
        });
        return submitButton;
    }
}
