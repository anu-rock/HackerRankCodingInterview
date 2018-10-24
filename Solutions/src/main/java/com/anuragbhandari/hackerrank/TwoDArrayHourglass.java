package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArrayHourglass {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Finds all hourglass formations in the given 2D array
     * and returns the sum of integers of the hourglass that has the max sum.
     * @param arr The 2D array in which to look for hourglass formations.
     * @return Max sum from among all hourglass formations.
     */
    static int getMaxHourglassSum(int[][] arr) {
        // Initialize the result variable
        int maxSum = -99; // cannot use 0 since all ints in an hourglass can be negative (min -9)
        // Initialize other variables
        int numRows = arr.length;
        int numCols = arr[0].length;
        // An hourglass formation requires an array to be at least 3x3
        if (numRows < 3 && numCols < 3) {
            throw new IllegalArgumentException("Min 3 columns and 3 rows are required.");
        }
        // The array is sufficient size
        else {
            // We can guess the number of hourglasses without even scanning the array
            // int numHourglasses = (numRows-2) * (numCols-2);
            for (int row=0; row < numRows-2; row++) {
                for (int col=0; col < numCols-2; col++) {
                    int hourglassSum = arr[row][col] + arr[row][col+1] + arr[row][col+2] +
                                                        arr[row+1][col+1] +
                                        arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
                    if (hourglassSum > maxSum) {
                        maxSum = hourglassSum;
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = getMaxHourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
