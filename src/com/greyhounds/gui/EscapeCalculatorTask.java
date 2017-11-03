package com.greyhounds.gui;
import com.greyhounds.math.*;

import javax.swing.SwingWorker;
import java.util.List;
import java.awt.Color;

public class EscapeCalculatorTask extends SwingWorker<PixelMap, Pixel> {
        private EscapeCalculator coordinateEscapeCalculator;
        private ComplexCoordinateMap coordinateMap;
        private PixelMap pixelMap;
        
        public EscapeCalculatorTask(PixelMap pixelMap, int iterationsOfMandelbrotFunction, int zoom) {
                this.pixelMap = pixelMap;
                int screenWidth = pixelMap.getWidth();
                int screenHeight = pixelMap.getHeight();
                
                coordinateEscapeCalculator = new EscapeCalculator(iterationsOfMandelbrotFunction, zoom);
                
                coordinateMap = new ComplexCoordinateMap(screenWidth, screenHeight);
                coordinateMap.zoomCoordinateMapBy(zoom);
        }
        
        @Override
        protected PixelMap doInBackground() {
                int bottomScreenPixelY = Window.getScreenHeight() - 2;
                for (int x = 0; x < Window.getScreenWidth(); x+=2) {
                        PixelColumn currentColumn = new PixelColumn(Window.getScreenHeight());
                        Color middleColor = Color.BLACK;
                        Color topPixelColor = Color.WHITE;
                        Color bottomPixelColor = Color.WHITE;
                        for (int topPixelY = 0, bottomPixelY = bottomScreenPixelY; topPixelY <= bottomPixelY; topPixelY+=2, bottomPixelY-=2) {
                                topPixelColor = getColorFor(x, topPixelY);
                                bottomPixelColor = getColorFor(x, bottomPixelY);
                                
                                System.out.println(x + " " + topPixelY);
                                System.out.println(x + " " + bottomPixelY);
                                Pixel topPixel = new Pixel(x, topPixelY, topPixelColor);
                                Pixel bottomPixel = new Pixel(x, bottomPixelY, bottomPixelColor);
                                
                                publish(topPixel);
                                publish(bottomPixel);
                        }
                }
                
                return pixelMap;
        }
        
        private Color getColorFor(int x, int y) {
                ScreenCoordinate screenCoordinate = new ScreenCoordinate(x, y);
                ComplexNumber complexCoordinate = coordinateMap.getComplexCoordinateAt(screenCoordinate);
                return coordinateEscapeCalculator.getMandelbrotColorFor(complexCoordinate);
        }
        
        @Override
        protected void process(List<Pixel> updatedPixels) {
                for (Pixel pixel : updatedPixels) {
                        pixelMap.add(pixel);
                }
        }
}
