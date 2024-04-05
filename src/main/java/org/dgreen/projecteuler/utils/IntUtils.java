package org.dgreen.projecteuler.utils;

import java.util.Arrays;

public class IntUtils {
    public static boolean isEven(int x) {
        return isDivisibleBy(x, 2);
    }

    public static boolean isDivisibleBy(int x, int y) {
        return x % y == 0;
    }

    public static boolean isDivisibleByNumbers(int number, int[] divisors) {
        return Arrays.stream(divisors)
                .mapToObj(divisor -> isDivisibleBy(number, divisor))
                .reduce(true, (a, b) -> a && b);
    }

    public static boolean isPalindrome(int x) {
        var asString = String.valueOf(x);
        return asString.equals(StringUtils.reverse(asString));
    }
}
