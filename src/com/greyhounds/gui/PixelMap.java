package com.greyhounds.gui;
import com.greyhounds.math.*;

import java.awt.Color;

public class PixelMap {
        private Pixel pixelMap[][];
        
        public PixelMap(int width, int height) {
                pixelMap = new Pixel[width][height];
        }
        
        public void add(Pixel pixel) {
                int x = pixel.getX();
                int y = pixel.getY();
                pixelMap[x][y] = pixel; 
        }
        
        public Color getPixelColorAt(ScreenCoordinate screenCoordinate) {
                int x = screenCoordinate.getX();
                int y = screenCoordinate.getY();
                return pixelMap[x][y].getColor();
        }
        
        public int getWidth() {
                return pixelMap.length;
        }
        
        public int getHeight() {
                return pixelMap[0].length;
        }
}
