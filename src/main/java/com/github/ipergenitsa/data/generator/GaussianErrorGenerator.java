package com.github.ipergenitsa.data.generator;

import java.util.Random;

/**
 * Created by ipergenitsa on 04.11.14.
 */
public class GaussianErrorGenerator implements ErrorGenerator {
    private Random random = new Random();

    @Override
    public double generateError() {
        return random.nextGaussian();
    }
}
