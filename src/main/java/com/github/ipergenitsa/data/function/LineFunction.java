package com.github.ipergenitsa.data.function;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class LineFunction implements Function {

    PolynomialFunction function;

    public LineFunction(double a, double b) {
        double[] coefficients = new double[2];
        coefficients[0] = b;
        coefficients[1] = a;
        function = new PolynomialFunction(coefficients);
    }

    @Override
    public double value(double x) {
        return function.value(x);
    }
}
