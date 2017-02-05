package com.greyhounds.gui;

/**
 * Created by nicholas on 2/4/17.
 */

import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    private GridBagConstraints constraints;
    private static int width;
    private static int height;

    public Window() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout();
        findScreenDimensions();
        this.setVisible(true);
        createPanel();
        this.setTitle("Mandelbrot Zoom - Micah Brewer and Nick Smith");
        //addWidgets();
    }

    private void setLayout() {
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
    }

    private void findScreenDimensions() {
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenDimensions.width;
        height = screenDimensions.height;
    }

    private void createPanel() {
        Mandelbrot panel = new Mandelbrot();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.weightx = 1;
        constraints.weighty = 0.9;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(panel, constraints);
    }

    private void addWidgets() {
        JPanel glassPane = new JPanel();
        glassPane.setLayout(new GridBagLayout());
        glassPane.setVisible(true);
        glassPane.setOpaque(false);

        JTextField field = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.4;
        constraints.weighty = 0.1;
        glassPane.add(field, constraints);

        JButton plus = new JButton("+");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        glassPane.add(plus, constraints);

        JButton minus = new JButton("-");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        glassPane.add(minus, constraints);

        JLabel zoom = new JLabel("1x");
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.weightx = 0.4;
        constraints.weighty = 0.1;
        glassPane.add(zoom, constraints);

        this.setTitle("Mandelbrot Zoom - Micah Brewer and Nick Smith");
        this.add(glassPane);
    }

    public static int getScreenWidth() {
        return width;
    }

    public static int getScreenHeight() {
        return height;
    }
}
