package com.github.ipergenitsa.data.generator;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class UniformXGenerator implements XGenerator {
    private double min, max;
    private int count;

    public UniformXGenerator(double min, double max, int count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }

    @Override
    public double[] generate() {
        double[] result = new double[count];
        double delta = (max - min) / (count - 1);
        for (int i = 0; i < count; i++) {
            result[i] = min + i * delta;
        }
        return result;
    }
}
