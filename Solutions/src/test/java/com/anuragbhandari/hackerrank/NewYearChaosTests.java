package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given final queue configurations as integer arrays")
public class NewYearChaosTests {
    @Test
    @DisplayName("return the correct number of minimum bribes required to get to each final configuration")
    void checkGetMinimumBribesOutput() {
        int[] queue_1 = { 2, 1, 5, 3, 4 };
        int[] queue_2 = { 2, 5, 1, 3, 4 };
        int[] queue_3 = { 5, 1, 2, 3, 7, 8, 6, 4 };
        int[] queue_4 = { 1, 2, 5, 3, 7, 8, 6, 4 };
        assertAll(
                () -> assertEquals(3, NewYearChaos.getMinimumBribes(queue_1)),
                () -> assertEquals(-1, NewYearChaos.getMinimumBribes(queue_2)),
                () -> assertEquals(-1, NewYearChaos.getMinimumBribes(queue_3)),
                () -> assertEquals(7, NewYearChaos.getMinimumBribes(queue_4)));
    }
}