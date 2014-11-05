package com.github.ipergenitsa.data.function;

import com.github.ipergenitsa.data.generator.ErrorGenerator;
import com.github.ipergenitsa.data.generator.GaussianErrorGenerator;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class LineWithErrorFunction implements Function {
    private LineFunction lineFunction;
    private ErrorGenerator errorGenerator;

    public LineWithErrorFunction(double a, double b) {
        this(a, b, new GaussianErrorGenerator());
    }

    public LineWithErrorFunction(double a, double b, ErrorGenerator errorGenerator) {
        lineFunction = new LineFunction(a, b);
        this.errorGenerator = errorGenerator;
    }


    @Override
    public double value(double x) {
        return lineFunction.value(x) + errorGenerator.generateError();
    }
}
