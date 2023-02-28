package org.tony.clarke.algo.searching;

import java.util.Arrays;

public class ThreeLargest {

    public static void main(String args[]) {
        int[] threeLargestNumbers = findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        for (int i : threeLargestNumbers) {
            System.out.println(i);
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int toReturn[] = new int[3];
        Arrays.fill(toReturn, Integer.MIN_VALUE);

        for (int i = 0; i < array.length; i++) {
            shiftIn(array[i], toReturn);
        }
        return toReturn;
    }

    private static void shiftIn(int i, int[] toReturn) {
        if (i >= toReturn[2]) {
            toReturn[0] = toReturn[1];
            toReturn[1] = toReturn[2];
            toReturn[2] = i;
        } else if (i >= toReturn[1]) {
            toReturn[0] = toReturn[1];
            toReturn[1] = i;
        } else if (i >= toReturn[0]) {
            toReturn[0] = i;
        }
    }
}
