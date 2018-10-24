package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given three 6x6 2D arrays of integers")
public class TwoDArrayHourglassTests {
    @Test
    @DisplayName("return the correct max sum from among all hourglasses for each array")
    void checkGetMaxHourglassSumOutput() {
        int[][] arr_1 = {
                { -9, -9, -9,  1, 1, 1  },
                { 0, -9,  0,  4, 3, 2 },
                { -9, -9, -9,  1, 2, 3 },
                { 0, 0, 8, 6, 6, 0 },
                { 0, 0, 0, -2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 }
        };
        int[][] arr_2 = {
                { 1, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0 },
                { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 }
        };
        int[][] arr_3 = {
                { -1, -1, 0, -9, -2, -2 },
                { -2, -1, -6, -8, -2, -5 },
                { -1, -1, -1, -2, -3, -4 },
                { -1, -9, -2, -4, -4, -5 },
                { -7, -3, -3, -2, -9, -9 },
                { -1, -3, -1, -2, -4, -5 }
        };
        assertAll(() -> assertEquals(28, TwoDArrayHourglass.getMaxHourglassSum(arr_1)),
                () -> assertEquals(19, TwoDArrayHourglass.getMaxHourglassSum(arr_2)),
                () -> assertEquals(-6, TwoDArrayHourglass.getMaxHourglassSum(arr_3)));
    }
}