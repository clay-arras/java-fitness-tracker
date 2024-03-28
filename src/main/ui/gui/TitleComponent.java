package ui.gui;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/*
Title component for GUI application, also fulfills the image part
 */
public class TitleComponent extends JLabel {
    static JLabel label;

    /*
    MODIFIES: this
    EFFECTS: constructor for making the label
     */
    public TitleComponent() throws MalformedURLException {
        String imagePath = "https://pngimg.com/d/dumbbell_PNG16384.png";
        URL imageURL = new URL(imagePath);

        ImageIcon image = new ImageIcon(imageURL);
        assert(image != null);
        label = new JLabel();
        label.setText("Workout Tracker APP");
        label.setIcon(image);
    }

    public static JLabel getLabel() {
        return label;
    }
}
