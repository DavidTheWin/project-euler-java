package org.dgreen.projecteuler.utils;

public class LongUtils {
    public static boolean isEven(long x) {
        return isDivisibleBy(x, 2);
    }

    public static boolean isDivisibleBy(long x, long y) {
        return x % y == 0;
    }

    public static long upperPrimeFactorLimitOf(long number) {
        return (long) Math.ceil(Math.sqrt(number));
    }

    public static boolean isPrime(long number) {
        if (number == 1 || number != 2 && isEven(number)) {
            return false;
        }

        for (long i = 3; i <= upperPrimeFactorLimitOf(number); i += 2) {
            if (isDivisibleBy(number, i)) {
                return false;
            }
        }

        return true;
    }

    public static long collatzLength(long number) {
        return collatzLength(number, 0);
    }

    private static long collatzLength(long number, long count) {
        count++;

        if (number == 1) {
            return count;
        }

        if (isEven(number)) {
            return collatzLength(number / 2, count);
        } else {
            return collatzLength(number * 3 + 1, count);
        }
    }
}
