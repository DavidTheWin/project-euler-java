package org.dgreen.projecteuler;

import java.util.stream.IntStream;

public class Problem17 {
    public static int numberOfLettersUpTo(int limit) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(Problem17::convertNumberToWord)
                .mapToInt(String::length)
                .sum();
    }

    // adapted from https://stackoverflow.com/a/76420699/4445414
    private static String convertNumberToWord(int number) {
        if (number == 0) return "zero";

        if (number < 20) return units[number];

        if (number < 100) return tens[number / 10] + units[number % 10];

        if (number < 1000)
            return units[number / 100] + "hundred" + (number % 100 == 0 ? "" : "and" + convertNumberToWord(number % 100));

        if (number == 1000) return "onethousand";

        throw new IllegalArgumentException(String.format("Number %d is out of range", number));
    }

    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
}
