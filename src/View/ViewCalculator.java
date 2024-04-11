package View;

import javax.swing.*;
import java.awt.*;

public class ViewCalculator extends JFrame {

    public ViewCalculator(){
        setSize(350, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void createLayout(){
        setLayout(new BorderLayout());

        ViewDisplay display = new ViewDisplay();
        display.setPreferredSize(new Dimension(200, 75));
        add(display, BorderLayout.NORTH);

        ViewKeyboard keyboard = new ViewKeyboard();
        add(keyboard, BorderLayout.CENTER);
    }
}
