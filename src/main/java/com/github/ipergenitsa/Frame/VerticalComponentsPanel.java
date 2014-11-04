package com.github.ipergenitsa.Frame;

import sun.awt.VerticalBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.peer.ButtonPeer;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class VerticalComponentsPanel extends JPanel {

    public VerticalComponentsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
