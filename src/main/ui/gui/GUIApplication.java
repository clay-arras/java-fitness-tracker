package ui.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/*
Main component for the GUI application
 */
public class GUIApplication extends JFrame {
    private final int HEIGHT = 1000;
    private final int WIDTH = 1400;
    static JFrame frame;

    /*
    MODIFIES: this
    EFFECTS: main runner for the application
     */
    public GUIApplication() {
        frame = new JFrame();

        MenuComponent menuComponent = new MenuComponent();
        frame.add(menuComponent.getPanel());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
