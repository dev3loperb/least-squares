package com.github.ipergenitsa.data.function;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class Cosinus implements Function {
    @Override
    public double value(double x) {
        return Math.cos(x);
    }
}
