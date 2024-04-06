package org.dgreen.projecteuler;

public class Problem9 {
    public static int productOfTriplet() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 1000; k++) {
                    var triple = new Triple(i, j, k);
                    if (triple.isPythagorean() && triple.sumsToOneThousand()) {
                        return triple.product();
                    }
                }
            }
        }

        throw new IllegalStateException("Did not find a pythagorean triple that sums to one thousand");
    }

    private record Triple(int a, int b, int c) {
        int product() {
            return a * b * c;
        }

        boolean isPythagorean() {
            return a < b && b < c && (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2));
        }

        boolean sumsToOneThousand() {
            return a + b + c == 1000;
        }
    }
}
