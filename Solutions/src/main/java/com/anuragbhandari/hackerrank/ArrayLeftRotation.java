package com.anuragbhandari.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayLeftRotation {

    // Instance variables
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Left rotates an array the specified number of times.
     * Returns the final rotated array.
     *
     * @param a source array to be rotated
     * @param d number of rotations
     * @return rotated array
     */
    static int[] rotLeft(int[] a, int d) {
        for (int i=0; i < d; i++) {
            a = rotateArray(a);
        }
        return a;
    }

    /**
     * Returns an array that is left-rotated 1 step.
     *
     * @param array source array to be rotated
     * @return rotated array
     */
    static int[] rotateArray(int[] array) {
        // Get target array's length
        int arrayLength = array.length;
        // Save the first element before modifying the array
        int firstElement = array[0];
        // Shift all elements to the left;
        // this will create a hole at array's tail
        for (int i=0; i < arrayLength - 1; i++) {
            array[i] = array[i+1];
        }
        // Fill array's tail with our saved first element
        array[arrayLength-1] = firstElement;
        return array;
    }

    public static void main(String[] args) throws IOException {
        // Read the input from stdin
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        // Rotate the input array
        int[] result = rotLeft(a, d);

        // Write the output to the specified file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        bufferedWriter.newLine();
        scanner.close();
    }
}