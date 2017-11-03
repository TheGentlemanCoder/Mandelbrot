package com.greyhounds.gui;
import com.greyhounds.math.*;

/**
 * Created by nicholas on 2/4/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class Mandelbrot extends JPanel {
    //private EscapeCalculator coordinateEscapeCalculator;
    //private ComplexCoordinateMap coordinateMap;
    private PixelMap pixelMap;
    private EscapeCalculatorTask mandelbrotGenerator;
    private int iterationsOfMandelbrotFunction = 13;
    
    
    private int zoom = 300;
    
    private int windowRefreshesPerSecond = 30;

    public Mandelbrot() {
        createPixelMap();
        createEscapeCalculatorTask();
        initializeRepaintTimer();
        startMandelbrotGeneration();
    }
    
    private void createPixelMap() {
        int screenWidth = Window.getScreenWidth();
        int screenHeight = Window.getScreenHeight();
        pixelMap = new PixelMap(screenWidth, screenHeight);
    }
    
    private void createEscapeCalculatorTask() {
        mandelbrotGenerator = new EscapeCalculatorTask(pixelMap, iterationsOfMandelbrotFunction, zoom);
    }
    
    private void startMandelbrotGeneration() {
        mandelbrotGenerator.execute();
    }
    
    private void initializeRepaintTimer() {
        ActionListener repaint = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                        refreshScreen();
                }
        };
        
        Timer repaintTimer = new Timer(1000/windowRefreshesPerSecond, repaint);
        repaintTimer.start();
    }

    public void updateScreenNestedArray(Graphics g) {
        for (int x = 0; x < Window.getScreenWidth(); x+=2) {
            for (int y = 0; y < Window.getScreenHeight(); y+=2) {
                ScreenCoordinate currentScreenCoordinate = new ScreenCoordinate(x, y);
                Color pixelColor = Color.WHITE;
                try {
                        pixelColor = pixelMap.getPixelColorAt(currentScreenCoordinate);
                } catch (NullPointerException ex) {
                        // The SwingWorker thread hasn't gotten to this pixel yet;
                        continue;
                }
                //System.out.println("This prints at least.");
                //ScreenCoordinate screenCoordinate = new ScreenCoordinate(x, y);
                //ComplexNumber complexCoordinate = coordinateMap.getComplexCoordinateAt(screenCoordinate);
                //Color coordinateColor = coordinateEscapeCalculator.getMandelbrotColorFor(complexCoordinate);
                g.setColor(pixelColor);
                //System.out.println(x + " " + y);
                g.fillRect(x, y, 2, 2);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateScreenNestedArray(g);
    }
    
    protected void refreshScreen() {
        this.repaint();
    }
}
