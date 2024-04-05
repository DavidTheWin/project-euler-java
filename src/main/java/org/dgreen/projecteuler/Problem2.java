package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

import java.util.stream.Stream;

public class Problem2 {
    public static int calculateEvenFibonacciSumUpTo(int limit) {
        return Stream
                .iterate(
                        new FibbPair(1, 1),
                        x -> x.sum <= limit,
                        f -> new FibbPair(f.sum, f.prev + f.sum)
                )
                .mapToInt(x -> x.sum)
                .filter(IntUtils::isEven)
                .sum();
    }

    record FibbPair(int prev, int sum) {
    }
}
