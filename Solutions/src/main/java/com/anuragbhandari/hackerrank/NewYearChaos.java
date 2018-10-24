package com.anuragbhandari.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prints the minimum number of bribes required to get from original queue state
     * to the given final state.
     * @param q Array of integers that represents final queue state.
     */
    static void printMinimumBribes(int[] q) {
        int result = getMinimumBribes(q);
        if (result == -1) {
            System.out.println("Too chaotic");
        }
        else {
            System.out.println(result);
        }
    }

    /**
     * Calculates the minimum number of bribes required to get from original queue state
     * to the given final state.
     * NOTE: This is not the optimal solution. Its complexity is less than the brute force solution (O(n2))
     * but more than the optimal solution (O(n)).
     * @param finalQueueState Array of integers that represents final queue state.
     * @return Total bribes, or -1 (if final queue state is too chaotic)
     */
    static int getMinimumBribes(int[] finalQueueState) {
        // Initialize the result variable
        int totalBribes = 0;
        // Initialize other variables
        Hashtable<Integer, Integer> bribeMap = new Hashtable<>();
        // Start with initial queue state (when all stickers are in order)
        int[] currentQueueState = new int[finalQueueState.length];
        for (int i=0; i < currentQueueState.length; i++) {
            currentQueueState[i] = i + 1;
        }
        // We'll start with the last sticker in final queue state
        int currentStickerNewIndex = finalQueueState.length - 1;
        // For each sticker in final queue state (starting from last)
        while(currentStickerNewIndex >= 0) {
            // Get current sticker details
            int currentSticker = finalQueueState[currentStickerNewIndex];
            Integer bribesByCurrentSticker = bribeMap.get(currentSticker);
            int currentStickerCurrentIndex = (bribesByCurrentSticker == null ?
                                                currentSticker - 1 : // sticker has not bribed, taking its original pos
                                                currentSticker - 1 - bribesByCurrentSticker); // sticker has bribed, taking its post-bribe position
            if (currentSticker == currentQueueState[currentStickerNewIndex]) {
                currentStickerNewIndex--;
                continue;
            }
            else {
                // Switch sticker positions to reach the queue state
                // as it was when the current sticker was pushed to where it is finally
                for (int i = currentStickerCurrentIndex + 1; i <= currentStickerNewIndex; i++) {
                    int briber = currentQueueState[i];
                    currentQueueState[i - 1] = briber;
                    Integer totalBribesByBriber = bribeMap.get(briber);
                    if (totalBribesByBriber == null) {
                        totalBribesByBriber = 1;
                    } else if (totalBribesByBriber > 0 && totalBribesByBriber < 2) {
                        totalBribesByBriber += 1;
                    } else {
                        return -1;
                    }
                    bribeMap.put(briber, totalBribesByBriber);
                    totalBribes += 1;
                }
                currentQueueState[currentStickerNewIndex] = currentSticker;
                currentStickerNewIndex--;
            }
        }
        return totalBribes;
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            printMinimumBribes(q);
        }

        scanner.close();
    }
}