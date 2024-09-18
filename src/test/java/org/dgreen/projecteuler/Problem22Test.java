package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem22Test {
    @Test
    void canSumNameSoresInFile() {
        assertThat(Problem22.sumOfNameScoresInFile()).isEqualTo(871198282);
    }
}
