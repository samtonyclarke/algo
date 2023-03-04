package org.tony.clarke.algo.sorting;

public class InsertionSort {

    public static void main(String args[]) {
        insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3});
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = i; // if we find a pair to swap then we need to track the new swapped position
            for (int j = i - 1; j >= 0; j--) {
                if (array[k] < array[j]) {
                    swap(array, k, j);
                    k--;
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
