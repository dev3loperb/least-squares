package com.github.ipergenitsa.data;

import com.github.ipergenitsa.data.function.Function;
import com.github.ipergenitsa.data.generator.XGenerator;
import com.github.ipergenitsa.method.SolutionLeastSquares;

import java.awt.*;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class DataStore {
    private SolutionLeastSquares solutionLeastSquares;
    private XGenerator xGenerator;
    private Function function;
    private int degreeOfPolynomial;

    public DataStore(int degreeOfPolynomial, XGenerator xGenerator, Function function) {
        this.xGenerator = xGenerator;
        this.function = function;
        this.degreeOfPolynomial = degreeOfPolynomial;
        updateValues();
    }

    public void updateValues() {
        if (solutionLeastSquares == null) {
            solutionLeastSquares = new SolutionLeastSquares(degreeOfPolynomial, xGenerator.generate(), function);
        }
        solutionLeastSquares.setNewData(degreeOfPolynomial, xGenerator.generate(), function);
    }

    public Image getSolutionAsImageAndUpdateData(int width, int height) {
        updateValues();
        return getSolutionAsImage(width, height);
    }

    public Image getSolutionAsImage(int width, int height) {
        return solutionLeastSquares.solutionImage(width, height);
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
