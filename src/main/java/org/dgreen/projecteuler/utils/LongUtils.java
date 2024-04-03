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

        for (int i = 3; i <= upperPrimeFactorLimitOf(number); i += 2) {
            if (isDivisibleBy(number, i)) {
                return false;
            }
        }

        return true;
    }
}
