package ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
Main hub for the application, which runs the main process loop
 */
public class Application {
    private boolean isDone;
    private final TrackerHandler handler;

    /*
    EFFECTS: initializes the application
     */
    public Application() {
        isDone = false;
        handler = new TrackerHandler();
    }

    /*
    EFFECTS: runs the application
     */
    public void run() {
        do {
            char option = optionSelector();
            if (option == 'a') {
                handler.addWorkout();
            } else if (option == 'r') {
                handler.removeWorkout();
            } else if (option == 'e') {
                handler.editWorkout();
            } else if (option == 'v') {
                handler.displayWorkouts();
            } else if (option == 'm') {
                handler.viewMetrics();
            } else if (option == 's') {
                handler.saveTracker();
            } else if (option == 'l') {
                handler.loadTracker();
            } else if (option == 'q') {
                isDone = true;
            }
        } while (!isDone);
    }

    /*
    EFFECTS: returns an option for the display
     */
    public char optionSelector() {
        char option = '\u0000';
        Set<Character> validOptions = new HashSet<>(Arrays.asList('a', 'r', 'e', 'v', 'm', 's', 'l', 'q'));
        Scanner scanner = new Scanner(System.in);

        String userPrompt = "Options:\n"
                + "a) add a new workout\n"
                + "r) remove a previous workout\n"
                + "e) edit a previous workout\n"
                + "v) view all previous workouts\n"
                + "m) view metrics\n"
                + "s) save workouts\n"
                + "l) load workouts\n"
                + "q) quit\n";

        System.out.println();
        System.out.println(userPrompt);
        option = scanner.next().charAt(0);

        while (!validOptions.contains(option)) {
            System.out.println("INVALID INPUT");
            System.out.println();
            System.out.println(userPrompt);
            option = scanner.next().charAt(0);
        }

        return option;
    }
}
