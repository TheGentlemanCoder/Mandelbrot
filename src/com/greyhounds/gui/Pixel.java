package com.greyhounds.gui;
import com.greyhounds.math.ScreenCoordinate;

import java.awt.Color;

public class Pixel extends ScreenCoordinate {
        private final Color pixelColor;
        
        public Pixel(int x, int y, Color color) {
                super(x, y);
                this.pixelColor = color;
        }
        
        public Color getColor() {
                return pixelColor;
        }
}
