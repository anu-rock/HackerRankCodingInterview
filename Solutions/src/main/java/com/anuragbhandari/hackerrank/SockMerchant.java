package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Returns the number of matching color sock pairs in pile.
     * @param n Number of socks in the pile.
     * @param ar Pile of socks represented as an integer array.
     * @return Number of matching pairs of socks.
     */
    static int identifyMatchingPairs(int n, int[] ar) {
        // Initialize the result variable
        int num_pairs = 0;
        // Create sock color map
        Hashtable<Integer, Integer> colorMap = createColorMap(n, ar);
        // Iterate the map to count total number of pairs
        for (Integer count : colorMap.values()) {
            num_pairs += count/2;
        }
        return num_pairs;
    }

    /**
     * Given a pile (array) of socks (integers), creates a map of each distinct sock color and its occurrences.
     * @param num_socks Number of socks in the pile.
     * @param sock_pile An array of integers, where each integer represents the color of corresponding sock.
     * @return Hashtable with color as key and total occurrences color as value.
     */
    private static Hashtable<Integer, Integer> createColorMap(int num_socks, int[] sock_pile) {
        Hashtable<Integer, Integer> colorMap = new Hashtable<Integer, Integer>();
        for (int i=0; i < num_socks; i++) {
            int sockColor = sock_pile[i];
            Integer colorCount = colorMap.get(sockColor);
            if (colorCount == null) {
                colorMap.put(sockColor, 1);
            }
            else {
                colorMap.put(sockColor, colorCount+1);
            }
        }
        return colorMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = identifyMatchingPairs(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
