package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountTriplets {

    /**
     * Returns the number of triplets forming a geometric progression for a given r as an integer.
     * @param arr An array of integers
     * @param r An integer, the common ratio
     * @return An integer, the number of triplets.
     */
    static long countTriplets(List<Long> arr, long r) {
        // Initialize the result variable
        long count = 0;
        // Given an array [1, 5, 5, 4, 25, 20, 100, 125] and r=5,
        // the array may be represented in terms of r as:
        // [1*r^0, 1*r^1, 1*r^1, 4*r^0, 1*r^2, 4*r^1, 4*r^2, 1*r^3].
        // Let's create a hash of hashes to track powers of r for each coefficient:
        // { 1 : { 0:1, 1:2, 2:1, 3:1 }, 4 : {0:1, 1:1, 2:1} }
        Hashtable<Long, Hashtable<Integer, Integer>> hash = new Hashtable<>();
        // Find coefficient and power, and update the hash
        for (Long num : arr) {
            long coefficient = 0;
            int powerOfR = -1;
            if (num == 1 || r == 1) {
                powerOfR = 0;
                coefficient = num;
                updateHash(hash, coefficient, powerOfR);
            }
            else if (num % r == 0) {
                powerOfR = getPowerOfR(num, r);
                coefficient = num / (long)Math.pow(r, powerOfR);
                updateHash(hash, coefficient, powerOfR);
            }
        }
        // To find triplets, we simply multiply occurrences of 3 consecutive powers of r
        // for each coefficient in our hash.
        // However, we have a special case when r=1.
        // So, for each coefficient:
        for (Long coff : hash.keySet()) {
            // Iterate all powers of that coefficient to find GP triplets
            Hashtable<Integer, Integer> coffHash = hash.get(coff);
            for (Integer pow : coffHash.keySet()) {
                if (r == 1) {
                    // Find nC3 combinations for this coefficient
                    count += combinations(coffHash.get(pow), 3);
                }
                else {
                    // Multiply occurrences of this power with those of 2 consecutive powers.
                    // Note that one or both consecutive powers may simply not exist in the hash,
                    // that's why we return a default value of 0 for such powers.
                    count += coffHash.get(pow) * coffHash.getOrDefault(pow + 1, 0) *
                            coffHash.getOrDefault(pow + 2, 0);
                }
            }
        }
        return count;

    }

    /**
     * Returns the power of r in num.
     * @param num An integer, a number in the format c * r^pow.
     * @param r An integer, the number that may be present multiple times in num.
     * @return An integer, the power of r.
     */
    static int getPowerOfR(long num, long r) {
        int power = 0;
        long coefficient = num;
        while (coefficient % r == 0) {
            coefficient = coefficient / r;
            power += 1;
        }
        return power;
    }

    /**
     * Increments power (of r) occurrences for the given coefficient in the given hash.
     */
    static void updateHash(Hashtable<Long, Hashtable<Integer, Integer>> hash, long coff, int pow) {
        // Get the hash for given coefficient
        Hashtable<Integer, Integer> coffHash = hash.get(coff);
        // Update the hash if it exists
        if (coffHash != null) {
            coffHash.merge(pow, 1, Integer::sum);
        }
        // Create a new hash if none exists
        else {
            coffHash = new Hashtable<Integer, Integer>();
            coffHash.put(pow, 1);
            hash.put(coff, coffHash);
        }
    }

    /**
     * Returns total combinations as denoted by nCr,
     * that is n! / (n-r)! * r!
     * @param n An integer, total items
     * @param r An integer, number of items to pick
     * @return total number of combinations
     */
    static long combinations(long n, long r) {
        if (n < r) {
            return 0L;
        }
        else {
            long numerator = 1, denominator = 1;
            if (r > n - r) {
                r = n - r;
            }
            for (long i = 1L; i <= r; ++i) {
                denominator *= i;
            }
            for (long i = n - r + 1L; i <= n; ++i) {
                numerator *= i;
            }
            return numerator / denominator;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
