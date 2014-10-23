package com.github.ipergenitsa;

import com.github.ipergenitsa.Frame.MainFrame;
import com.github.ipergenitsa.method.MethodLeastSquares;
import org.apache.commons.math3.analysis.function.Pow;

/**
 * Created by ipergenitsa on 09.10.14.
 */
public class Main {
    public static void main(String[] args) {
        double[] x = new double[] {-2, 0, 1, 2, 4};//{0, 1, 2, 4, 5};
        double[] y = new double[] {0.5, 1, 1.5, 2, 3};//{2.1, 2.4, 2.6, 2.8, 3.0};
        MethodLeastSquares methodLeastSquares = new MethodLeastSquares(1, x, y);
        System.out.println(methodLeastSquares.getSolution());
        MainFrame mainFrame = new MainFrame(500, 400);
    }
}
