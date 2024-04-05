package org.dgreen.projecteuler;

import java.util.stream.IntStream;

import static org.dgreen.projecteuler.utils.IntUtils.isDivisibleBy;

public class Problem1 {
    public static int calculateSumOfThreesAndFivesUpTo(int limit) {
        return IntStream.range(1, limit)
                .filter(x -> isDivisibleBy(x, 3) || isDivisibleBy(x, 5))
                .sum();
    }
}
