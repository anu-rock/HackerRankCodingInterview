package com.anuragbhandari.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class HashtableRansomNote {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Read the input from stdin
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] magazine = new String[m];
        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }
        String[] note = new String[n];
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        // Find out the result
        String res = checkMagazine(magazine, note);

        // Write the output to the specified file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bufferedWriter.write(res);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    /**
     * Checks whether all words (case-sensitive) in note are in magazine.
     * @param magazine an array of words in magazine
     * @param note an array of words in array
     * @return Yes if note can be formed from words in magazine, No otherwise
     */
    public static String checkMagazine(String[] magazine, String[] note) {
        // Create hashes from arrays for fast searching
        Hashtable<String, Integer> hashMagazine = createHashtable(magazine);
        Hashtable<String, Integer> hashNote = createHashtable(note);
        // Start with positive assumption for result
        String result = "Yes";
        // Update result to "No" if any word in note is not present in magazine
        for (String word : hashNote.keySet()) {
            if (!hashMagazine.containsKey(word) || (hashMagazine.get(word) < hashNote.get(word))) {
                result = "No";
                break;
            }
        }
        // Return the result
        return result;
    }

    /**
     * Creates and returns a Hashtable of words and their occurrences in the specified array of strings.
     * @param wordArray array of strings
     * @return a Hashtable with words in array as keys and their occurrences as values
     */
    private static Hashtable createHashtable(String[] wordArray) {
        // Initialize a new Hashtable
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        for (String word : wordArray) {
            int occurrences = 1;
            // Increment word's occurrence if it is already in hash
            if (hash.containsKey(word)) {
                occurrences = hash.get(word);
                occurrences++;
            }
            // Update word's occurrences in hash
            hash.put(word, occurrences); // adds a new key-value pair if key doesn't exist
        }
        // Return the resulting hash
        return hash;
    }
}
