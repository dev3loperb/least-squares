package com.github.ipergenitsa.Frame;

import com.github.ipergenitsa.data.DataStore;
import com.github.ipergenitsa.data.function.Function;
import com.github.ipergenitsa.data.function.LineWithErrorFunction;
import com.github.ipergenitsa.data.generator.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by ipergenitsa on 19.10.14.
 */
public class MainFrame extends JFrame {
    private static final String PARAMS_TEXT_FIELD_ID = "params";
    private static final String PARAMS_TEXT_FIELD_VALUE = "params";
    private static final String BUILD_BUTTON_NAME = "Build";
    private DataStore dataStore = new DataStore(1, new RandomXGenerator(-5, 5, 10),
            //new CosinusWithError(new GaussianErrorGenerator()));
            new LineWithErrorFunction(1, 2, new GaussianErrorGenerator()));
    private JPanel mainPanel;
    private DrawPanel drawPanel;
    private ComponentsPanel componentsPanel;
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
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        mainPanel.setLayout(flowLayout);
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

    private void initComponentsPanel() {
        componentsPanel = new ComponentsPanel();
        componentsPanel.addButton(BUILD_BUTTON_NAME, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String params = componentsPanel.getValueOfTextField(PARAMS_TEXT_FIELD_ID);
                String[] paramsAsArray = params.split("\\,");
                dataStore.setFunction(new LineWithErrorFunction(Double.valueOf(paramsAsArray[0]),
                        Double.valueOf(paramsAsArray[1])));
                draw();
            }
        });
        componentsPanel.addLabeledTextField(PARAMS_TEXT_FIELD_ID, PARAMS_TEXT_FIELD_VALUE);
    }

    private void draw() {
        drawPanel.setImage(dataStore.getSolutionAsImageAndUpdateData(drawPanel.getWidth(), drawPanel.getHeight()));
        drawPanel.repaint();
    }

    private void init() {
        initMainPanel(width, height);
        initDrawPanel((int) (width * 0.75), height - 2);
        initComponentsPanel();
        mainPanel.add(drawPanel);
        mainPanel.add(componentsPanel);
        mainPanel.setBorder(new LineBorder(Color.RED));
        drawPanel.setBorderColor(Color.GREEN);
        initFrame();
    }
}
