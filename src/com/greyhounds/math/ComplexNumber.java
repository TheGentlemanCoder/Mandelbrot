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

    public void setReal(BigDecimal x) {
        real = x;
    }

    public void setImaginary(BigDecimal y){
        imaginary = y;
    }

    public ComplexNumber addition(ComplexNumber z){
        real = real.add(z.getReal());
        imaginary = imaginary.add(z.getImaginary());
        return new ComplexNumber(real, imaginary);
    }
}