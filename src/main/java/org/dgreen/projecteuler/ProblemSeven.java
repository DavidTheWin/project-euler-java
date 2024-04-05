package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

public class ProblemSeven {
    public static int nthPrimeNumber(int n) {
        var primeCount = 0;

        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (IntUtils.isPrime(i)) {
                primeCount++;

                if (primeCount == n) {
                    return i;
                }
            }
        }

        var errorMessage = String.format("Did not find the nth prime number (%d) up to %d", n, Integer.MAX_VALUE);
        throw new IllegalStateException(errorMessage);
    }
}
