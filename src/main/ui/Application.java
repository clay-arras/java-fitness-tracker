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
            switch (option) {
                case 'a':
                    handler.addWorkout();
                    break;
                case 'r':
                    handler.removeWorkout();
                    break;
                case 'e':
                    handler.editWorkout();
                    break;
                case 'v':
                    handler.displayWorkouts();
                    break;
                case 'm':
                    handler.viewMetrics();
                    break;
                case 's':
                    handler.saveTracker();
                    break;
                case 'l':
                    handler.loadTracker();
                    break;
                case 'q':
                    isDone = true;
                    break;
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
