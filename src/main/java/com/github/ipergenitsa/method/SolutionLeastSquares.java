package com.github.ipergenitsa.method;

import com.github.ipergenitsa.data.function.Function;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ipergenitsa on 03.11.14.
 */
public class SolutionLeastSquares {

    private MethodLeastSquares methodLeastSquares;
    private double xMin = -10;
    private double xMax = 10;
    private double yMin = -10;
    private double yMax = 10;
    private double step = 0.01;

    public SolutionLeastSquares(int degreeOfPolynomial, double[] experimentalDataX, double[] experimentalDataY) {
        setNewData(degreeOfPolynomial, experimentalDataX, experimentalDataY);
    }

    public SolutionLeastSquares(int degreeOfPolynomial, double[] experimentalDataX, Function function) {
        setNewData(degreeOfPolynomial, experimentalDataX, function);
    }

    public void setNewData(int degreeOfPolynomial, double[] experimentalDataX, Function function) {
        methodLeastSquares = new MethodLeastSquares(degreeOfPolynomial, experimentalDataX,
                calculateExperimentalDataY(experimentalDataX, function));
    }

    public void setNewData(int degreeOfPolynomial, double[] experimentalDataX, double[] experimentalDataY) {
        methodLeastSquares = new MethodLeastSquares(degreeOfPolynomial, experimentalDataX, experimentalDataY);
    }

    private double[] calculateExperimentalDataY(double[] experimentalDataX, Function function) {
        double[] experimentalDataY = new double[experimentalDataX.length];
        for (int i = 0; i < experimentalDataX.length; i++) {
            experimentalDataY[i] = function.value(experimentalDataX[i]);
        }
        return experimentalDataY;
    }

    public double[] solution() {
        return methodLeastSquares.getSolution();
    }

    public Image solutionImage(int width, int height) {
        Image resultImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics resultImageGraphics = resultImage.getGraphics();
        resultImageGraphics.setColor(Color.LIGHT_GRAY);
        resultImageGraphics.fillRect(0, 0, width, height);
        resultImageGraphics.setColor(Color.CYAN);
        drawCoordinateLines(resultImageGraphics, width, height, xMin, xMax, yMin, yMax);
        resultImageGraphics.setColor(Color.BLACK);
        drawPolynomial(resultImageGraphics, width, height, xMin, xMax, yMin, yMax);
        resultImageGraphics.setColor(Color.RED);
        drawExperimentalPoints(resultImageGraphics, width, height,
                methodLeastSquares.getExperimentalDataX(), methodLeastSquares.getExperimentalDataY());

        return resultImage;
    }

    private void drawPolynomial(Graphics graphics, int width, int height, double xMin, double xMax, double yMin,
                                double yMax) {
        int xOld, yOld;
        PolynomialFunction polynomialFunction = new PolynomialFunction(solution());
        xOld = 0;
        yOld = (int)polynomialFunction.value(xOld);
        yOld = (int)((yOld - yMin) / (yMax - yMin) * height);
        for (double x = xMin; x < xMax; x += step) {
            double y = polynomialFunction.value(x);
            int pointX = (int)coordinateToImageCoordinates(x, xMin, xMax, width);
            int pointY = height - (int)coordinateToImageCoordinates(y, yMin, yMax, height);
            graphics.drawLine(xOld, yOld, pointX, pointY);
            xOld = pointX;
            yOld = pointY;
        }
    }

    private void drawCoordinateLines(Graphics graphics, int width, int height, double xMin, double xMax, double yMin,
                                     double yMax) {
        int xCoordinatesLine = (int)coordinateToImageCoordinates(0, xMin, xMax, width);
        int yCoordinatesLine = (int)coordinateToImageCoordinates(0, yMin, yMax, height);
        graphics.drawLine(xCoordinatesLine, 0, xCoordinatesLine, height);
        graphics.drawLine(0, yCoordinatesLine, width, yCoordinatesLine);
    }

    private void drawExperimentalPoints(Graphics graphics, int width, int height, double[] x, double[] y) {
        for (int i = 0; i < x.length; i++) {
            int xPoint = (int)coordinateToImageCoordinates(x[i], xMin, xMax, width);
            int yPoint = height - (int)coordinateToImageCoordinates(y[i], yMin, yMax, height);
            graphics.drawArc(xPoint - 2, yPoint - 2, 4, 4, 0, 360);
        }
    }

    private double coordinateToImageCoordinates(double coordinate, double coordinateMin,
                                                double coordinateMax, int imageSize) {
        return ((coordinate - coordinateMin) / (coordinateMax - coordinateMin) * imageSize);
    }

}
