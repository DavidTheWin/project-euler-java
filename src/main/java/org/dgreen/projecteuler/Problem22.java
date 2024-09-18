package org.dgreen.projecteuler;

import org.dgreen.projecteuler.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem22 {
    public static int sumOfNameScoresInFile() {
        var names = Arrays.stream(readNamesFromFile()).sorted().toList();

        return IntStream.range(0, names.size())
                .map(i -> nameScore(names.get(i), i))
                .sum();
    }

    private static int nameScore(String name, int index) {
        return name.chars().map(x -> x - 64).sum() * (index + 1);
    }

    private static String[] readNamesFromFile() {
        try (var content = FileUtils.inputStreamOfFile("Problem22-names.txt")) {
            return new String(content.readAllBytes())
                    .replace("\"", "")
                    .split(",");
        } catch (IOException e) {
            System.err.printf("Failed to read file content %s\n", e.getMessage());
            System.exit(1);
        }

        throw new IllegalStateException("Should not be able to reach here");
    }
}
