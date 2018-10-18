package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given two cloud sequences (integer arrays)")
public class JumpingOnTheCloudsTests {
    @Test
    @DisplayName("return the correct number of min jumps required to win game")
    void checkGetMinJumpsToFinishOutput() {
        int[] cloud_seq_1 = {0, 0, 1, 0, 0, 1, 0};
        int[] cloud_seq_2 = {0, 0, 0, 0, 1, 0};
        assertAll(() -> assertEquals(4, JumpingOnTheClouds.getMinJumpsToFinish(cloud_seq_1)),
                () -> assertEquals(3, JumpingOnTheClouds.getMinJumpsToFinish(cloud_seq_2)));
    }
}
