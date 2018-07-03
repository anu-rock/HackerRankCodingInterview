package com.anuragbhandari.hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

@Nested
@DisplayName("given two string arrays")
public class HashtableRansomNoteTests {
    @Test
    @DisplayName("return the correct output (Yes or No) when strings in one array are checked against strings in second array")
    void validateCheckMagazineOutput() {
        String[] magazine1 = new String[] {"give", "me", "one", "grand", "today", "night"};
        String[] note1 = new String[] {"give", "one", "grand", "today",};
        String[] magazine2 = new String[] {"two", "times", "three", "is", "not", "four"};
        String[] note2 = new String[] {"two", "times", "two", "is", "four"};
        String[] magazine3 = new String[] {"apgo", "clm", "w", "lxkvg", "mwz", "elo", "bg", "elo", "lxkvg", "elo",
                                            "apgo", "apgo", "w", "elo", "bg"};
        String[] note3 = new String[] {"elo", "apgo", "apgo", "w", "elo", "bg"};
        assertAll(() -> assertEquals("Yes", HashtableRansomNote.checkMagazine(magazine1, note1)),
                () -> assertEquals("No", HashtableRansomNote.checkMagazine(magazine2, note2)),
                () -> assertEquals("Yes", HashtableRansomNote.checkMagazine(magazine3, note3)));
    }
}
