package com.jay.guava.stream;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Sleeper
 * @Description
 * @Date 2019/3/1
 * @Author lufangjie
 * @Version 1.0
 **/
public class Sleeper {

    private static final Random RANDOM = new Random();

    static void randSleep(double mean, double stdDev) {
        final double micros = 1_000 * (mean + RANDOM.nextGaussian() * stdDev);
        try {
            TimeUnit.MICROSECONDS.sleep((long) micros);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
