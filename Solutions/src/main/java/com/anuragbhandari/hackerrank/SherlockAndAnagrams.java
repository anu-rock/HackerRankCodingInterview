package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Given a string, returns the number of pairs of substrings of the string that are anagrams of each other.
     * @param s The string to check.
     * @return An integer that represents the number of anagrammatic pairs of substrings in s.
     */
    static int getNumAnagrammaticPairs(String s) {
        // Initialize the result variable
        int numPairs = 0;
        // Initialize other variables
        Hashtable<String, Integer> substrCountMap = new Hashtable<>();
        // For each possible substring length
        for (int strLen = 1; strLen <= s.length() - 1; strLen++) {
            // Find all substrings of selected length
            for(int strStartIndex = 0; strStartIndex <= s.length() - strLen; strStartIndex++) {
                // Read the substring
                char[] substr = s.substring(strStartIndex, strStartIndex+strLen).toCharArray();
                // Sort the substring
                // NOTE: Sorting is our clever trick to ensure all anagrams of a string
                // will be represented by the same key (in the map).
                // OPTIMIZATION NOTE:
                // We are using sorted string as a 'signature'.
                // That is, all anagrams of a string will have the same signature.
                // Sorting has an average case complexity of nlog(n).
                // There's a better way to create signatures (in linear running time).
                // This way is similar to the counting sort trick,
                // and is mentioned in detail in the Editorial for this problem.
                Arrays.sort(substr);
                // Update its entry in the map
                // NOTE: merge method is a shorthand for two separate tasks:
                // 1. If the given key does not exist, add it and set its value to 1.
                // 2. If the given key exists, increment is value by 1.
                substrCountMap.merge(new String(substr), 1, Integer::sum);
            }
        }
        // Iterate the map to count pairs
        for (Integer anagramCount : substrCountMap.values()) {
            // We need the count to be at least 2 to make a pair
            if (anagramCount > 1) {
                // The number of pairs that can be formed out of the given count (c)
                // will be equal to the sum of arithmetic progression 1 ... (c-1).
                // Eg. For a substring 'abc' whose variations occur 3 times (eg. 'abc', 'bac', 'cba'),
                // the number of pairs that can be formed is 2 + 1 + 0 = 3.
                numPairs += arithmeticProgressionSum(1, anagramCount - 1, anagramCount - 1);
            }
        }
        return numPairs;
    }

    /**
     * Returns the sum of an AP represented by given parameters.
     * @param a First integer in progression.
     * @param l Last integer in progression
     * @param n Number of integers in progression.
     * @return Sum of the series.
     */
    private static int arithmeticProgressionSum(int a, int l, int n) {
        return (n * (a + l)) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = getNumAnagrammaticPairs(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
