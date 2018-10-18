package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given two piles of multi-colored socks")
public class SockMerchantTests {
    @Test
    @DisplayName("return the correct number of matching pairs of socks in each pile")
    void checkIdentifyMatchingPairsOutput() {
        int[] pile_1 = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] pile_2 = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
        assertAll(() -> assertEquals(3, SockMerchant.identifyMatchingPairs(pile_1.length, pile_1)),
                () -> assertEquals(4, SockMerchant.identifyMatchingPairs(pile_2.length, pile_2)));
    }
}
