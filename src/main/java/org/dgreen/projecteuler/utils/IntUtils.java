package org.dgreen.projecteuler.utils;

public class IntUtils {
    public static boolean isEven(int x) {
        return isDivisibleBy(x, 2);
    }

    public static boolean isDivisibleBy(int x, int y) {
        return x % y == 0;
    }

    public static boolean isDivisibleByNumbers(int number, int[] divisors) {
        for (int divisor : divisors) {
            if (!isDivisibleBy(number, divisor)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(int x) {
        var asString = String.valueOf(x);
        return asString.equals(StringUtils.reverse(asString));
    }

    public static int upperPrimeFactorLimitOf(int number) {
        return (int) Math.ceil(Math.sqrt(number));
    }

    public static boolean isPrime(int number) {
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
