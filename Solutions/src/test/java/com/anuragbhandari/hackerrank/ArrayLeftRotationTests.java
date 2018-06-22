package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given a valid array of integers and a rotation count")
class CorrectnessTests {
    @Test
    @DisplayName("perform the given number of left rotations and return the correct output")
    void checkLeftRotationOutput() {
        int[] arrayOne = new int[] {1, 2, 3, 4, 5};
        int arrayOneRotations = 4;
        int[] arrayOneRotated = new int[] {5, 1, 2, 3, 4};
        int[] arrayTwo = new int[] {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
        int arrayTwoRotations = 10;
        int[] arrayTwoRotated = new int[] {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
        assertAll(() -> assertArrayEquals(arrayOneRotated, ArrayLeftRotation.rotLeft(arrayOne, arrayOneRotations)),
                  () -> assertArrayEquals(arrayTwoRotated, ArrayLeftRotation.rotLeft(arrayTwo, arrayTwoRotations)));
    }
}