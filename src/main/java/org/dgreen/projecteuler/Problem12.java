package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;

public class Problem12 {
    public static int firstTriangleNumberWithAtLeastNDivisors(int numberOfDivisors) {
        for (int n = 1; n < Integer.MAX_VALUE; n++) {
            var triangleNumber = IntUtils.nthTriangleNumber(n);
            var numberOfDivisorsOf = IntUtils.numberOfDivisorsOf(triangleNumber);

            if (numberOfDivisorsOf >= numberOfDivisors) {
                return triangleNumber;
            }
        }

        var errorMessage = String.format(
                "Did not find a triangle number with %d divisors up to %d",
                numberOfDivisors,
                Integer.MAX_VALUE);
        throw new IllegalStateException(errorMessage);
    }
}
