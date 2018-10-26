package com.anuragbhandari.hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given a few different strings")
public class SherlockAndAnagramsTests {
    @Test
    @DisplayName("return the correct number of anagrammatic pairs of substrings in each string")
    void checkGetNumAnagrammaticPairsOutput() {
        String s1 = "abba";
        String s2 = "abcd";
        String s3 = "ifailuhkqq";
        String s4 = "kkkk";
        String s5 = "cdcd";
        assertAll(
                () -> assertEquals(4, SherlockAndAnagrams.getNumAnagrammaticPairs(s1)),
                () -> assertEquals(0, SherlockAndAnagrams.getNumAnagrammaticPairs(s2)),
                () -> assertEquals(3, SherlockAndAnagrams.getNumAnagrammaticPairs(s3)),
                () -> assertEquals(10, SherlockAndAnagrams.getNumAnagrammaticPairs(s4)),
                () -> assertEquals(5, SherlockAndAnagrams.getNumAnagrammaticPairs(s5)));
    }
}