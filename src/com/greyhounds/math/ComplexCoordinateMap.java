package com.greyhounds.math;

import java.math.BigDecimal;

public class ComplexCoordinateMap {
        private ComplexNumber coordinateMap[][];
        
        public ComplexCoordinateMap(int width, int height) {
                coordinateMap = new ComplexNumber[width][height];
        }
        
        public ComplexNumber getComplexCoordinateAt(ScreenCoordinate screenCoordinate) {
                int x = screenCoordinate.getX();
                int y = screenCoordinate.getY();
                return coordinateMap[x][y];
        }
        
        public void zoomCoordinateMapBy(int zoom) throws ArithmeticException {
                validateNotZero(zoom);
                
                int width = coordinateMap.length;
                int height = coordinateMap[0].length;
                
                System.out.println("width: " + width + " height: " + height);
                
                
                int originX = width/2;
                int originY = height/2;
                
                for (int screenX = 0; screenX < width; screenX+=2) {
                        for (int screenY = 0; screenY < height; screenY+=2) {
                                // Algorithm assumes a 1:zoom ratio between pixels and theoretical coordinates.
                                // For example, the point (5, 5) relative to the middle of the screen with a zoom of 10
                                // would have the ComplexCoordinate (0.5, 0.5i)
                                BigDecimal newReal = new BigDecimal( ((double) (screenX - originX)) / ((double) zoom));
                                BigDecimal newImaginary = new BigDecimal( ((double) (screenY - originY)) / ((double) zoom));
                                
                                System.out.println("screenX: " + screenX + " screenY: " + screenY);
                                coordinateMap[screenX][screenY] = new ComplexNumber(newReal, newImaginary);
                        }
                }
        }
        
        private void validateNotZero(int zoom) throws ArithmeticException {
                if (zoom == 0) {
                        throw new ArithmeticException("Divide by zero error. The Mandelbrot Set zoom cannot be set to zero.");
                }
        }
}
