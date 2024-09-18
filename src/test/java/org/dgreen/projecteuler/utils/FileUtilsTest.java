package org.dgreen.projecteuler.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class FileUtilsTest {
    @Test
    void canUseAnInputStreamFromAResourcesFile() {
        try (var content = FileUtils.inputStreamOfFile("test-file.txt")) {
            assertThat(new String(content.readAllBytes())).isEqualTo("some test content\n");
        } catch (IOException e) {
            fail(String.format("Failed to read from file %s", e.getMessage()));
        }
    }
}
