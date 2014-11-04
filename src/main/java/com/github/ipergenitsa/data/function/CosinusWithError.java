package com.github.ipergenitsa.data.function;

import com.github.ipergenitsa.data.generator.ErrorGenerator;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class CosinusWithError implements Function {
    private Cosinus cosinus = new Cosinus();
    private ErrorGenerator errorGenerator;

    public CosinusWithError(ErrorGenerator errorGenerator) {
        this.errorGenerator = errorGenerator;
    }

    @Override
    public double value(double x) {
        return cosinus.value(x) + errorGenerator.generateError();
    }
}
