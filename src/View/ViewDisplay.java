package View;

import models.Memory;
import models.MemoryObserver;

import javax.swing.*;
import java.awt.*;

public class ViewDisplay extends JPanel implements MemoryObserver {

    private final JLabel label;

    public ViewDisplay() {
        Memory.getInst().addObserver(this);
        setBackground(new Color(46, 49, 50));
        label = new JLabel(Memory.getInst().getText());
        label.setForeground(Color.white);
        label.setFont(new Font("jetbrains mono", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        add(label);

    }
    @Override
    public void setActualText(String newText) {
        label.setText(newText);
    }
}
