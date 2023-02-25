package org.tony.clarke.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]) {
        int[] bubbleSorted = bubbleSort(new int[]{4, 2, 3, 1});
        Arrays.stream(bubbleSorted).forEach(i -> {
            System.out.println(i);
        });
    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);
        return array;
    }
}
