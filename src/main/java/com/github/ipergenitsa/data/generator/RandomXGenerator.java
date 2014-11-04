package com.github.ipergenitsa.data.generator;

import java.util.Random;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class RandomXGenerator implements XGenerator {

    private double delta;
    private UniformXGenerator uniformXGenerator;
    private Random random = new Random();

    public RandomXGenerator(double min, double max, int count) {
        uniformXGenerator = new UniformXGenerator(min, max, count);
        delta = (max - min) / count;
    }

    @Override
    public double[] generate() {
        double[] result = uniformXGenerator.generate();
        for (int i = 0; i < result.length; i++) {
            result[i] += random.nextDouble() * delta;
        }
        return result;
    }
}
