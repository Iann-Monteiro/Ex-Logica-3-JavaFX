package View;

import models.Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewKeyboard extends JPanel implements ActionListener {

    private final Color DARK_GRAYCOLOR = new Color(68, 69, 68);
    private final Color LIGHT_GRAYCOLOR = new Color(99, 99, 99);
    private final Color ORANGECOLOR = new Color(242, 163, 60);

    public ViewKeyboard() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        //LINE 1
        constraints.gridwidth = 3;
        buttonAdd("AC", DARK_GRAYCOLOR, constraints, 0, 0);
        constraints.gridwidth = 1;
        buttonAdd("÷", ORANGECOLOR, constraints, 3, 0);

        //LINE 2
        buttonAdd("7", LIGHT_GRAYCOLOR, constraints, 0, 1);
        buttonAdd("8", LIGHT_GRAYCOLOR, constraints, 1, 1);
        buttonAdd("9", LIGHT_GRAYCOLOR, constraints, 2, 1);
        buttonAdd("X", ORANGECOLOR, constraints, 3, 1);

        //LINE 3
        buttonAdd("4", LIGHT_GRAYCOLOR, constraints, 0, 2);
        buttonAdd("5", LIGHT_GRAYCOLOR, constraints, 1, 2);
        buttonAdd("6", LIGHT_GRAYCOLOR, constraints, 2, 2);
        buttonAdd("-", ORANGECOLOR, constraints, 3, 2);

        //LINE 4
        buttonAdd("1", LIGHT_GRAYCOLOR, constraints, 0, 3);
        buttonAdd("2", LIGHT_GRAYCOLOR, constraints, 1, 3);
        buttonAdd("3", LIGHT_GRAYCOLOR, constraints, 2, 3);
        buttonAdd("+", ORANGECOLOR, constraints, 3, 3);

        //LINE 5
        constraints.gridwidth = 2;
        buttonAdd("0", LIGHT_GRAYCOLOR, constraints, 0, 4);
        constraints.gridwidth = 1;
        buttonAdd(".", LIGHT_GRAYCOLOR, constraints, 2, 4);
        buttonAdd("=", ORANGECOLOR, constraints, 3, 4);
    }

    public void buttonAdd(String text, Color color, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        Button button = new Button(text, color);
        button.addActionListener(this);
        add(button, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton button) {
            Memory.getInst().commandProcess(button.getText());
        }
    }
}
