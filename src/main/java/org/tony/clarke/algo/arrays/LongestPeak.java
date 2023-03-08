package org.tony.clarke.algo.arrays;

public class LongestPeak {

    public static void main(String args[]) {
//        int i = longestPeak(
//                new int[]{1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1});
        int i = longestPeak(
                new int[]{1, 1, 3, 2, 1});
        System.out.println(i);
    }

    public static int longestPeak(int[] array) {
        // first and last element cannot be a peak
        if (array.length < 3) {
            return 0;
        }
        int longestPeak = -1;
        int currentUpsCount = 0;
        boolean reachedPeak = false;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) { // peak
                reachedPeak = true;
                currentUpsCount++;
            } else if (array[i] < array[i - 1] && array[i] < array[i + 1]) { // trough
                currentUpsCount++;
                // stop counting at trough
                if (reachedPeak && currentUpsCount > longestPeak) {
                    longestPeak = currentUpsCount;
                }
                reachedPeak = false;
                currentUpsCount = 0;
            } else if (array[i] > array[i - 1]) { // going up
                if (!reachedPeak) {
                    currentUpsCount++;
                }
            } else if (array[i] < array[i - 1]) { // going down
                if (reachedPeak) {
                    currentUpsCount++;
                }
            } else {
                reachedPeak = false;
                currentUpsCount = 0;
            }
            if (reachedPeak && currentUpsCount > longestPeak) {
                longestPeak = currentUpsCount;
            }
        }
        if (reachedPeak && array[array.length - 1] < array[array.length - 2]) {
            currentUpsCount++;
        }
        if (reachedPeak && currentUpsCount > longestPeak) {
            longestPeak = currentUpsCount;
        }

        return longestPeak + 1; // +1 because we didn't count the first entry
    }
}
