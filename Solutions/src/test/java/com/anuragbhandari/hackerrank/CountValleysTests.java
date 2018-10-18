package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given two strings describing steps")
public class CountValleysTests {
    @Test
    @DisplayName("return the correct number of valleys detected in each path")
    void checkGetNumValleysOutput() {
        String path_1 = "UDDDUDUU";
        String path_2 = "DDUUDDUDUUUD";
        assertAll(() -> assertEquals(1, CountingValleys.getNumValleys(path_1.length(), path_1)),
                () -> assertEquals(2, CountingValleys.getNumValleys(path_2.length(), path_2)));
    }
}
