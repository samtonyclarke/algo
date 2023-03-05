package org.tony.clarke.algo.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String args[]) {
        int[] selectionSort = selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        for (int i : selectionSort) {
            System.out.print(i + " ");
        }
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for (int j = i; j < array.length; j++) {
                if (array[j]<smallest) {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }
            swap(array, i, smallestIndex);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
