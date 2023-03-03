package org.tony.clarke.algo.arrays;

import java.util.Arrays;

public class SortedSquareArray {

    public static void main(String args[]) {
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        int[] sortedSquaredArray = sortedSquareArray.sortedSquaredArray(new int[]{-2, -1});
        for (int i : sortedSquaredArray) {
            System.out.println(i);
        }
    }

    public int[] sortedSquaredArray(int[] array) {
        boolean needToSort = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                needToSort = true;
            }
            array[i] = array[i] * array[i];
        }
        if (needToSort) {
            Arrays.sort(array);
        }
        return array;
    }
}
