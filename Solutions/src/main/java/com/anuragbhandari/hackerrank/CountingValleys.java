package com.anuragbhandari.hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Returns the number of valleys detected in the given path.
     * @param n Number of steps in the path.
     * @param s The path string, which is a sequence of steps taken by hiker.
     * @return Total number of valleys found in path.
     */
    static int getNumValleys(int n, String s) {
        // Initialize the result variable
        int numValleys = 0;
        // Initialize other tracking variables
        int altitudeAboveSeaLevel = 0;
        boolean inValley = false;
        char[] steps = s.toCharArray();
        // Check each step
        for (char step : steps) {
            // Indicates start of a valley
            if (altitudeAboveSeaLevel == 0 && step == 'D') {
                inValley = true;
            }
            // Increment sea level if up step is encountered
            if (step == 'U') {
                altitudeAboveSeaLevel += 1;
            }
            // Decrement sea level if down step is encountered
            else if (step == 'D') {
                altitudeAboveSeaLevel -= 1;
            }
            // Indicates end of a valley
            if (step == 'U' && altitudeAboveSeaLevel == 0) {
                numValleys += 1;
                inValley = false;
            }
        }
        return numValleys;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = getNumValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
