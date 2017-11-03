package com.greyhounds.math;
import com.greyhounds.gui.*;

import java.math.BigDecimal;

public class TheoreticalTransformation {
        public static ComplexNumber transform(int x, int y, int zoom) {
                BigDecimal real = new BigDecimal( (double) (x - Window.getScreenWidth()/2) / (double) zoom);
                BigDecimal imaginary = new BigDecimal( (double) (y - Window.getScreenHeight()/2) / (double) zoom);
                return new ComplexNumber(real, imaginary);
        }
}
