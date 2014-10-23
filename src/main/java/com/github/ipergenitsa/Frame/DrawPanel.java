package com.github.ipergenitsa.Frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by ipergenitsa on 19.10.14.
 */
public class DrawPanel extends JPanel {

    private Image image;

    /**
     * Create new LineBorder with color: "color"
     * @param color
     */
    public void setBorderColor(Color color) {
        setBorder(new LineBorder(color));
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        }
    }
}
