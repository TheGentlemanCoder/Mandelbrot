package com.greyhounds.math;

public class ScreenCoordinate {
        protected final int x;
        protected final int y;
        
        public ScreenCoordinate(int x, int y) {
                this.x = x;
                this.y = y;
        }
        
        public int getX() {
                return x;
        }
        
        public int getY() {
                return y;
        }
}
