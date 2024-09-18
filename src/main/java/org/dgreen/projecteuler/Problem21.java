package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem21 {
    public static int sumOfAmicableNumbersUpTo(int limit) {
        return IntStream.range(1, limit)
                .filter(Problem21::isAmicable)
                .sum();
    }

    private static boolean isAmicable(int n) {
        var sumOfDivisors = Arrays.stream(IntUtils.properDivisorsOf(n)).sum();
        if (n == sumOfDivisors) return false;
        var sumOfPairedNumber = Arrays.stream(IntUtils.properDivisorsOf(sumOfDivisors)).sum();
        return sumOfPairedNumber == n;
    }
}
