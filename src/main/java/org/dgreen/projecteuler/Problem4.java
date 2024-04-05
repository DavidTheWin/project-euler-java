package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.IntUtils;
import org.dgreen.projecteuler.utils.Pair;

import java.util.List;
import java.util.stream.IntStream;

public class Problem4 {
    public static int largestPalindromeByProductsUpTo(int limit) {
        return allPairsUpToLimit(limit)
                .stream()
                .mapToInt(it -> it.first() * it.second())
                .distinct()
                .filter(IntUtils::isPalindrome)
                .max()
                .orElse(0);
    }

    static List<Pair> allPairsUpToLimit(int limit) {
        return IntStream.range(1, limit + 1)
                .boxed()
                .flatMap(first ->
                        IntStream.range(1, limit)
                                .mapToObj(second -> new Pair(first, second))
                )
                .toList();
    }
}
