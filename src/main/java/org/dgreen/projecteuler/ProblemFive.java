package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

import java.util.stream.IntStream;

public class ProblemFive {
    public static int smallestNumberEvenlyDivisibleByNumbersUpTo(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException(String.format("The limit must be at least 1, was %d", limit));
        }

        var divisors = IntStream.rangeClosed(1, limit).toArray();

        for (int n = 1; n < Integer.MAX_VALUE; n++) {
            if (IntUtils.isDivisibleByNumbers(n, divisors)) {
                return n;
            }
        }

        var errorString = String.format("Did not find a number up to %d " +
                "divisible by all numbers up to %d", Integer.MAX_VALUE, limit);
        throw new IllegalStateException(errorString);
    }
}
