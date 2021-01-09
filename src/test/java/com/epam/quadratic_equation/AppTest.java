package com.epam.quadratic_equation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(value = Parameterized.class)
public class AppTest {
    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;
    private final BigDecimal[] roots;

    public AppTest(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal[] roots) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.roots = roots;
    }

    @Test
    public void solveQuadraticEquationTest() {
        assertArrayEquals(roots, App.solveQuadraticEquation(a, b, c));
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1),
                        new BigDecimal[]{}},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(1),
                        new BigDecimal[]{BigDecimal.valueOf(-1)}},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(-4),
                        new BigDecimal[]{BigDecimal.valueOf(1), BigDecimal.valueOf(-2)}},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(0),
                        new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(-1)}},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(0), BigDecimal.valueOf(-2),
                        new BigDecimal[]{BigDecimal.valueOf(1), BigDecimal.valueOf(-1)}},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(2), BigDecimal.valueOf(-2),
                        new BigDecimal[]{BigDecimal.valueOf(1)}},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(1),
                        new BigDecimal[]{BigDecimal.valueOf(Double.MIN_VALUE),
                                BigDecimal.valueOf(Double.MAX_VALUE)}},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0),
                        new BigDecimal[]{BigDecimal.valueOf(Double.MIN_VALUE),
                                BigDecimal.valueOf(Double.MAX_VALUE)}}
        });
    }
}
