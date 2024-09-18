package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Problem17Test {
    @Test
    void canCountLettersUsedUpToFive() {
        assertThat(Problem17.numberOfLettersUpTo(5)).isEqualTo(19);
    }

    @Test
    void canCountLettersUsedUpToOneThousand() {
        assertThat(Problem17.numberOfLettersUpTo(1000)).isEqualTo(21124);
    }

    @Test
    void throwsIllegalArgumentExceptionWhenItCannotConvertNumberToString() {
        assertThatThrownBy(() -> Problem17.numberOfLettersUpTo(10000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number 1001 is out of range");
    }
}
