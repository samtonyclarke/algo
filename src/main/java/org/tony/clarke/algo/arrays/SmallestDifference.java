package org.tony.clarke.algo.arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String args[]) {
        int[] ints = smallestDifference(new int[]{0, 20}, new int[]{21, -2});
        System.out.println(ints[0] + " " + ints[1]);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int smallestDif = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int one = arrayOne[0];
        int two = arrayTwo[0];
        while (i < arrayOne.length && j < arrayTwo.length) {
            int diffCalc = diffCalc(arrayOne[i], arrayTwo[j]);
            if (diffCalc < smallestDif) {
                one = arrayOne[i];
                two = arrayTwo[j];
                smallestDif = diffCalc;
            }
            if (arrayOne[i] < arrayTwo[j]) {
                i++;
                continue;
            }
            j++;
        }
        return new int[]{one, two};
    }

    private static int diffCalc(int a, int b) {
        return Math.abs((a - b));
    }


}
