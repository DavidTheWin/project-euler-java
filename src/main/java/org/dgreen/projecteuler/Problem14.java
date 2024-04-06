package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.LongUtils;

public class Problem14 {
    public static int numberThatHasTheLongestChainUpToN(int n) {
        var longestChain = 0L;
        var numberWithLongestChain = 0;

        for (int i = 1; i < n; i++) {
            var chainLength = LongUtils.collatzLength(i);
            if (chainLength > longestChain) {
                longestChain = chainLength;
                numberWithLongestChain = i;
            }
        }

        return numberWithLongestChain;
    }
}
