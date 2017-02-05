package com.greyhounds.gui;
import com.greyhounds.math.*;

/**
 * Created by nicholas on 2/4/17.
 */
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class Mandelbrot extends JPanel {
    private EscapeCalculator calculator = new EscapeCalculator();
    private ComplexNumber pixels[][];
    private BigDecimal zoom = new BigDecimal(1);
    private BigDecimal scale = new BigDecimal(5);

    public Mandelbrot() {
        this.repaint();
    }

    public void updateScreenNestedArray(Graphics g) {
        int originX = Window.getScreenWidth()/2;
        int originY = Window.getScreenHeight()/2;

        BigDecimal real;
        BigDecimal imaginary;

        pixels = new ComplexNumber[Window.getScreenWidth()][Window.getScreenHeight()];
        for (int x = 0; x < Window.getScreenWidth(); x+=8) {
            for (int y = 0; y < Window.getScreenHeight(); y+=8) {
                pixels[x][y] = calculator.scale(x, y);
                Color color = calculator.calculate(pixels[x][y]);
                g.setColor(color);
                g.drawRect(x, y, 8, 8);
                System.out.println(x + " " + y);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        updateScreenNestedArray(g);
    }
}
