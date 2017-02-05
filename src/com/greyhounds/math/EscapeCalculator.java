package com.greyhounds.math;
import com.greyhounds.gui.Window;
/**
 * Created by nicholas and micah on 2/4/17.
 */

import java.math.BigDecimal;
import java.awt.*;

/**
 *  f(c)=
 */
public class EscapeCalculator {
    int x = 0;
    int y = 0;
    float velocity;
    private BigDecimal two = new BigDecimal(2);
    private ComplexNumber c = new ComplexNumber(BigDecimal.ONE, two);



    public Color calculate(ComplexNumber number) {
        ComplexNumber iteratedNumber = number;
        for(int i = 0;i< 10;i++){
            iteratedNumber = iteratedNumber.square();
            iteratedNumber = iteratedNumber.addition(c);
        }

        if (iteratedNumber.getReal().compareTo(number.getReal()) < 0 &&
                iteratedNumber.getImaginary().compareTo(number.getImaginary()) < 0) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    public ComplexNumber scale(int x, int y) {
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigY = new BigDecimal(y);

        BigDecimal zoom = new BigDecimal(500);

        BigDecimal halfWidth = new BigDecimal(-Window.getScreenWidth()/2);
        BigDecimal halfHeight = new BigDecimal(-Window.getScreenHeight()/2);

        BigDecimal real = halfWidth.divide(two).add(zoom.multiply(bigX));
        BigDecimal imaginary = halfHeight.divide(two).add(zoom.multiply(bigY));

        return new ComplexNumber(real, imaginary);
    }
}