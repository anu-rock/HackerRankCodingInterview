package com.anuragbhandari.hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Nested
@DisplayName("given integer arrays and corresponding common ratios")
public class CountTripletsTests {
    @Test
    @DisplayName("return the correct number of triplets forming a geometric progression for the given r")
    void checkCountTripletsOutput() {
        List<Long> arr_1 = new ArrayList<Long>(Arrays.asList(1L, 2L, 2L, 4L));
        List<Long> arr_2 = new ArrayList<Long>(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L));
        List<Long> arr_3 = new ArrayList<Long>(Arrays.asList(1L, 5L, 5L, 25L, 125L));
        List<Long> arr_4 = new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 1L));
        assertAll(
//                () -> assertEquals(2, CountTriplets.countTriplets(arr_1, 2)),
//                () -> assertEquals(6, CountTriplets.countTriplets(arr_2, 3)),
//                () -> assertEquals(4, CountTriplets.countTriplets(arr_3, 5)),
                () -> assertEquals(4, CountTriplets.countTriplets(arr_4, 1)));
    }
}
