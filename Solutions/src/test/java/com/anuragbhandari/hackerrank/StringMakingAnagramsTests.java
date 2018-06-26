package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("given two strings")
public class StringMakingAnagramsTests {
    @Test
    @DisplayName("return the correct number of character deletions required to make the two strings anagrams")
    void checkMakeAnagramOutput() {
        String sample1A = "cde";
        String sample1B = "abc";
        String sample2A = "fcrxzwscanmligyxyvym";
        String sample2B = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        assertAll(() -> assertEquals(4, StringMakingAnagrams.makeAnagram(sample1A, sample1B)),
                  () -> assertEquals(30, StringMakingAnagrams.makeAnagram(sample2A, sample2B)));
    }
}
