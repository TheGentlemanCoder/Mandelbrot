package com.greyhounds.math;

import java.math.BigDecimal;
import java.awt.Color;

public class EscapeCalculator {
        private int functionIterations;
        private BigDecimal lowerMandelbrotBound = new BigDecimal(0.5);
        private BigDecimal squareOfMandelbrotEscapeDistance = new BigDecimal(4);
        private BigDecimal mandelbrotEscapeDistance = new BigDecimal(2);
        
        public EscapeCalculator(int functionIterations, int zoom) {
                this.functionIterations = functionIterations;
        }
        
        public void setFunctionIterationsTo(int newFunctionIterations) {
                this.functionIterations = newFunctionIterations;
        }
        
        public Color getMandelbrotColorFor(ComplexNumber coordinate) {
                Color coordinateColor;
                if (coordinate.getReal().compareTo(mandelbrotEscapeDistance) == 1 ||
                    coordinate.getImaginary().compareTo(mandelbrotEscapeDistance) == 1) {
                        coordinateColor = Color.WHITE;
                } else {
                        ComplexNumber iteratedCoordinate = getIteratedCoordinateFrom(coordinate);
                        coordinateColor = getColorFrom(iteratedCoordinate);
                }
                
                return coordinateColor;
        }
        
        private ComplexNumber getIteratedCoordinateFrom(ComplexNumber coordinate) {
                ComplexNumber iteratedNumber = coordinate;
                
                for (int i = 0; i < functionIterations; i++) {
                    iteratedNumber = iteratedNumber.square().add(coordinate);
                    if (iteratedNumber.getReal().compareTo(mandelbrotEscapeDistance) == 1||
                        iteratedNumber.getImaginary().compareTo(mandelbrotEscapeDistance) == 1) {
                        break;
                    }
                }
                
                return iteratedNumber;
        }
        
        private Color getColorFrom(ComplexNumber coordinate) { 
                BigDecimal squareOfDistanceFromOrigin = coordinate.getReal().pow(2).add(coordinate.getImaginary().pow(2));
                if (squareOfDistanceFromOrigin.compareTo(squareOfMandelbrotEscapeDistance) == 1) {
                        return Color.WHITE;
                } else {
                        return Color.BLACK;
                }
        }
}
