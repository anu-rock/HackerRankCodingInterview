package com.anuragbhandari.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StringMakingAnagrams {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Read the input from stdin
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        // Find out the result
        int res = makeAnagram(a, b);

        // Write the output to the specified file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    /**
     * Returns minimum number characters required to be deleted from two separate strings
     * in order to make them anagrams of each other.
     * @param a first string
     * @param b second string
     * @return minimum number of characters to be deleted
     */
    public static int makeAnagram(String a, String b) {
        // Convert input strings into lists
        // (remember: strings are immutable, lists can be manipulated)
        List<Character> aList = createCharList(a);
        List<Character> bList = createCharList(b);
        // Find out the number of common characters between the 2 strings
        int numCommonChars = 0;
        for (char c : aList) {
            int idx = bList.indexOf(c);
            if (idx != -1) {
                numCommonChars += 1;
                bList.remove(idx);
            }
        }
        // Calculate the total char deletions required
        int numCharDeletionsInA = a.length() - numCommonChars;
        int numCharDeletionsInB = bList.size();
        return numCharDeletionsInA + numCharDeletionsInB;
    }

    /**
     * Creates and returns a character list for the specified string.
     * @param sourceStr string to convert to char list
     * @return list of chars object
     */
    private static List<Character> createCharList(String sourceStr) {
        List<Character> list = new ArrayList<Character>();
        for (char c : sourceStr.toCharArray()) {
            list.add(c);
        }
        return list;
    }
}
