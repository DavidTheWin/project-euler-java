package org.dgreen.projecteuler.utils;

import java.io.InputStream;

public class FileUtils {
    public static InputStream inputStreamOfFile(String filename) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    }
}
