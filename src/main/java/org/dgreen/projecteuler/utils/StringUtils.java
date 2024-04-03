package org.dgreen.projecteuler.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    public static String reverse(String str) {
        return Stream.of(str)
                .map(it -> new StringBuilder(it).reverse())
                .collect(Collectors.joining());
    }
}
