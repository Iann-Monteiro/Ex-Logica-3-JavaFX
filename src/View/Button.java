package View;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button() {
    }

    public Button(String label, Color color) {
        setText(label);
        setFont(new Font("jetbrains mono", Font.PLAIN, 25));
        setOpaque(true);
        setBackground(color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
