package com.anuragbhandari.hackerrank;

import java.io.*;
import java.util.*;

public class RepeatedString {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Returns the number of occurrences of 'a' in the first n characters of
     * infinitely repeated string s.
     * @param s The string to be infinitely repeated.
     * @param n Number of characters to pick from the beginning of s.
     * @return Total occurrences of 'a' in the repeated string.
     */
    static long getAOccurrences(String s, long n) {
        // Initialize the result variable
        long aOccurrencesInRepeatedS = 0;
        // Calculate occurrences of 'a' in s
        int aOccurrencesInS = 0;
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            if (c == 'a') {
                aOccurrencesInS += 1;
            }
        }
        // Calculate approximate a occurrences in first n chars of repeated string
        long numSRepetitionsInN = n / s.length();
        aOccurrencesInRepeatedS += numSRepetitionsInN * aOccurrencesInS;
        // Calculate exact occurrences in first n chars of repeated string
        long numSRemainderCharsInN = n % s.length();
        int aOccurrencesInRemainderS = 0;
        for (int i=0; i < numSRemainderCharsInN; i++) {
            if (sArray[i] == 'a') {
                aOccurrencesInRemainderS += 1;
            }
        }
        aOccurrencesInRepeatedS += aOccurrencesInRemainderS;
        return aOccurrencesInRepeatedS;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = getAOccurrences(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

