package ui.gui;

import javax.swing.*;

/*
Title component for GUI application, also fulfills the image part
 */
public class TitleComponent {
    private final JLabel label;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the label
     */
    public TitleComponent() {
        ImageIcon image = new ImageIcon("assets/image.png");
        assert (image != null);
        label = new JLabel();
        label.setText("Workout Tracker APP");
        label.setIcon(image);
    }

    public JLabel getLabel() {
        return label;
    }
}
