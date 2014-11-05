package com.github.ipergenitsa.Frame;

import javax.swing.*;
import java.util.*;
import java.util.List;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class ComponentsPanel extends JPanel {

    private List<JButton> jButtons = new ArrayList<JButton>();
    private Map<String, JLabeledTextField> jLabeledTextFields = new HashMap<String, JLabeledTextField>();

    public ComponentsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addButton(String label, AbstractAction abstractAction) {
        JButton button = new JButton(label);
        button.addActionListener(abstractAction);
        jButtons.add(button);
        add(button);
    }

    public void addLabeledTextField(String id, String label) {
        JLabeledTextField jLabeledTextField = new JLabeledTextField(label);
        jLabeledTextFields.put(id, jLabeledTextField);
        add(jLabeledTextField);
    }

    public String getValueOfTextField(String id) {
        return jLabeledTextFields.get(id).getText();
    }
}
