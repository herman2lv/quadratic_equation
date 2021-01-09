package com.epam.quadratic_equation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class App {
    private static final BigDecimal DISCRIMINANT_FORMULA_COEFFICIENT = BigDecimal.valueOf(4);
    private static final BigDecimal ROOT_FORMULA_COEFFICIENT = BigDecimal.valueOf(2);

    private App() {
    }

    /**
     * Solve quadratic equation in standard form: ax^2 + bx + c = 0.
     *
     * @param a {@code BigDecimal} coefficient 'a'
     * @param b {@code BigDecimal} coefficient 'b'
     * @param c {@code BigDecimal} coefficient 'c'
     *
     * @return array of {@code BidDecimal} values of roots of equation.
     *          Array may contain 2, 1 or 0 roots. In case of infinite
     *          roots array contains max and min values of {@code Double}.
     */
    public static BigDecimal[] solveQuadraticEquation(BigDecimal a, BigDecimal b, BigDecimal c) {
        if (a.compareTo(BigDecimal.valueOf(0)) == 0) {
            if (b.compareTo(BigDecimal.valueOf(0)) == 0) {
                return new BigDecimal[]{BigDecimal.valueOf(Double.MIN_VALUE),
                        BigDecimal.valueOf(Double.MAX_VALUE)};
            } else {
                return new BigDecimal[] {c.negate().divide(b, RoundingMode.HALF_UP)};
            }
        }
        BigDecimal d = getDiscriminant(a, b, c);
        if (d.compareTo(BigDecimal.valueOf(0)) < 0) {
            return new BigDecimal[]{};
        }
        BigDecimal root1 = b.negate().add(d.sqrt(MathContext.DECIMAL64));
        root1 = root1.divide(a.multiply(ROOT_FORMULA_COEFFICIENT), RoundingMode.HALF_UP);
        if (d.compareTo(BigDecimal.valueOf(0)) == 0) {
            return new BigDecimal[]{root1};
        }
        BigDecimal root2 = b.negate().subtract(d.sqrt(MathContext.DECIMAL64));
        root2 = root2.divide(a.multiply(ROOT_FORMULA_COEFFICIENT), RoundingMode.HALF_UP);
        return new BigDecimal[]{root1, root2};
    }

    private static BigDecimal getDiscriminant(BigDecimal a, BigDecimal b, BigDecimal c) {
        return b.pow(2).subtract(a.multiply(c).multiply(DISCRIMINANT_FORMULA_COEFFICIENT));
    }
}
