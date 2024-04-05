package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

import java.util.stream.IntStream;

public class ProblemTen {
    public static long sumOfPrimesUpTo(int limit) {
        return IntStream.rangeClosed(1, limit)
                .filter(IntUtils::isPrime)
                .mapToLong(Long::valueOf)
                .sum();
    }
}
