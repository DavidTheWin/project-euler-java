package org.dgreen.projecteuler;

import java.util.stream.IntStream;

public class ProblemSix {
    public static int sumSquareDifferenceUpTo(int limit) {
        return squareSum(limit) - sumSquares(limit);
    }

    static int sumSquares(int limit) {
        return IntStream.rangeClosed(1, limit)
                .map(n -> n*n)
                .sum();
    }

    static int squareSum(int limit) {
        var sum = IntStream.rangeClosed(1, limit).sum();
        return sum * sum;
    }
}
