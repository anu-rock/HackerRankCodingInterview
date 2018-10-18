package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given two strings and number of characters to consider in them")
public class RepeatedStringTests {
    @Test
    @DisplayName("return the correct number of occurrences of 'a' in the infinitely repeated strings")
    void checkGetNumOfACharsOutput() {
        String s_1 = "aba";
        String s_2 = "a";
        long n_1 = 10;
        long n_2 = 1000000000000L;
        assertAll(() -> assertEquals(7, RepeatedString.getAOccurrences(s_1, n_1)),
                () -> assertEquals(1000000000000L, RepeatedString.getAOccurrences(s_2, n_2)));
    }
}

