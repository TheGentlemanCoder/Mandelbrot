package com.greyhounds.math;
import com.greyhounds.gui.*;
/**
 * Created by nicholas on 2/4/17.
 */

import java.math.BigDecimal;

public class ComplexNumber {
    private BigDecimal real;
    private BigDecimal imaginary;

    public ComplexNumber(BigDecimal real, BigDecimal imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber square() {
        // z = a + bi
        // z^2 = (a + bi)(a + bi)
        //     =  a^2 + 2abi + (b^2)(i^2)
        //     =  a^2 + 2abi + (b^2)(-1)
        // z^2 =  (a^2 - b^2) + 2abi
        BigDecimal a = real.multiply(real).subtract(imaginary.multiply(imaginary));
        BigDecimal b = real.multiply(imaginary).multiply(new BigDecimal(2));

        //real = a;
        //imaginary = b;
        return new ComplexNumber(a, b);
    }

    public BigDecimal getReal() {
        return real;
    }

    public BigDecimal getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber z) {
        real = real.add(z.getReal());
        imaginary = imaginary.add(z.getImaginary());
        return new ComplexNumber(real, imaginary);
    }
    
    public ComplexNumber subtract(ComplexNumber z) {
        real = real.subtract(z.getReal());
        imaginary = imaginary.subtract(z.getImaginary());
        return new ComplexNumber(real, imaginary);
    }
    
    public BigDecimal getRadiusWithPrecision(int decimalsOfPrecision) {           
        BigDecimal distanceFromOrigin = BigMath.sqrt(real.pow(2).add(imaginary.pow(2)), decimalsOfPrecision);
        return distanceFromOrigin;
   }
}
