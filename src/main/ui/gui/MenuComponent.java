package ui.gui;

import javax.swing.*;
import java.net.MalformedURLException;

/*
Container for the titleComponent
 */
public class MenuComponent extends JPanel {
    private final int HEIGHT = 600;
    private final int WIDTH = 400;
    static JPanel panel;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the panel
     */
    public MenuComponent() {
        panel = new JPanel();
        panel.setSize(HEIGHT, WIDTH);
        TitleComponent titleComponent = null;
        try {
            titleComponent = new TitleComponent();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        panel.add(titleComponent.getLabel());
    }

    public static JPanel getPanel() {
        return panel;
    }
}
