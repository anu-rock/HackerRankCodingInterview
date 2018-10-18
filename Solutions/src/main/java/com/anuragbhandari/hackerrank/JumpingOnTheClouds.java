package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int SMALL_JUMP = 1;
    private static final int BIG_JUMP = 2;

    /**
     * Returns minimum number of jumps required to win game.
     * @param c Integer Array of clouds, where 0 represents a safe and 1 an unsafe cloud.
     * @return Number of jumps required to get from first to last cloud.
     */
    static int getMinJumpsToFinish(int[] c) {
        // Initialize the result variable
        int jumps = 0;
        // Initialize other tracking variables
        int currentPos = 0;
        // Start the game
        while (currentPos < c.length - 1) {
            // Potential new positions
            int posAfterSmallJump = currentPos + SMALL_JUMP;
            int posAfterBigJump = currentPos + BIG_JUMP;
            // Making a big jump will land player on a safe cloud
            if (currentPos < c.length - 2 && c[posAfterBigJump] == 0) {
                currentPos = posAfterBigJump; // make a big jump
            }
            // Making a big jump will land player on an unsafe cloud
            else {
                currentPos = posAfterSmallJump; // make a small jump
            }
            // Increment total jumps
            jumps += 1;
        }
        return jumps;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = getMinJumpsToFinish(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
