package com.github.ipergenitsa.method;

import org.apache.commons.math3.analysis.function.Pow;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by ipergenitsa on 09.10.14.
 */
public class MethodLeastSquares {
    private int degreeOfPolynomial;
    private double[] experimentalDataX;
    private double[] experimentalDataY;
    private double[] rightPart;

    public RealMatrix getMatrix() {
        return matrix;
    }

    private RealMatrix matrix;

    public MethodLeastSquares(int degreeOfPolynomial, double[] experimentalDataX, double[] experimentalDataY) {
        this.degreeOfPolynomial = degreeOfPolynomial;
        this.experimentalDataX = experimentalDataX;
        this.experimentalDataY = experimentalDataY;
        matrix = new Array2DRowRealMatrix(degreeOfPolynomial + 1, degreeOfPolynomial + 1);
    }

    public void fillMatrix() {
        for (int j = 0; j < degreeOfPolynomial + 1; j++) {
            for (int i = 0; i < degreeOfPolynomial + 1; i++) {
                double entryMatrix = 0;
                for (int k = 0; k < experimentalDataX.length; k++) {
                    entryMatrix += new Pow().value(experimentalDataX[k], i + j);
                }
                matrix.setEntry(i, j, entryMatrix);
            }
        }
    }

    public void computeY() {
        rightPart = new double[degreeOfPolynomial + 1];

        for (int i = 0; i < degreeOfPolynomial + 1; i++) {
            rightPart[i] = 0;
            for (int j = 0; j < experimentalDataX.length; j++) {
                rightPart[i] += experimentalDataY[j] * FastMath.pow(experimentalDataX[j], i);
            }
        }
    }

    public RealVector solve() {
        DecompositionSolver solver = new LUDecomposition(matrix).getSolver();
        RealVector constants = new ArrayRealVector(rightPart, false);
        RealVector solution = solver.solve(constants);
        return solution;
    }
}
