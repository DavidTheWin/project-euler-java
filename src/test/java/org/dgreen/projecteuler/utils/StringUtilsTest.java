package org.dgreen.projecteuler.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @Test
    void canReverseAString() {
        assertThat(StringUtils.reverse("12345")).isEqualTo("54321");
        assertThat(StringUtils.reverse("1")).isEqualTo("1");
        assertThat(StringUtils.reverse("")).isEqualTo("");
    }
}