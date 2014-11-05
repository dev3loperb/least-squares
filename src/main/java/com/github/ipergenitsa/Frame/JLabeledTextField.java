package com.github.ipergenitsa.Frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ipergenitsa on 05.11.14.
 */
public class JLabeledTextField extends JPanel {
    private JLabel jLabel;
    private JTextField jTextField;

    public JLabeledTextField(String label) {
        jLabel = new JLabel(label);
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(50, 20));
        add(jLabel);
        add(jTextField);
    }

    public String getText() {
        return jTextField.getText();
    }
}
