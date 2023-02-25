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
        int a = 0;
        do {
            swapped = false;
            for (int i = 0; i < array.length - (1 + a); i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            a++;
        } while (swapped == true);
        return array;
    }
}
