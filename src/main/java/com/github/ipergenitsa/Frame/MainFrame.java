package com.github.ipergenitsa.Frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by ipergenitsa on 19.10.14.
 */
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private DrawPanel drawPanel;
    private int height;
    private int width;


    public MainFrame(int width, int height) {
        super("Least squares");
        this.height = height;
        this.width = width;
        init();
    }

    private void initMainPanel(int width, int height) {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(width, height));
    }

    private void initDrawPanel(int width, int height) {
        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(width, height));
    }

    private void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private void init() {
        initMainPanel(width, height);
        initDrawPanel((int)(width * 0.8), height);
        mainPanel.add(drawPanel);
        mainPanel.setBorder(new LineBorder(Color.RED));
        drawPanel.setBorderColor(Color.GREEN);
        initFrame();
    }
}
