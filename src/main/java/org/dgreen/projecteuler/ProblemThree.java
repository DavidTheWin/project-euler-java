package org.dgreen.projecteuler;

import java.util.stream.LongStream;

import org.dgreen.projecteuler.utils.LongUtils;
import static org.dgreen.projecteuler.utils.LongUtils.isDivisibleBy;
import static org.dgreen.projecteuler.utils.LongUtils.upperPrimeFactorLimitOf;

public class ProblemThree {
    public static long largestPrimeFactorOf(long number) {
        return LongStream.rangeClosed(1, upperPrimeFactorLimitOf(number))
                .filter(LongUtils::isPrime)
                .filter(factor -> isDivisibleBy(number, factor))
                .max()
                .orElse(0);
    }
}
