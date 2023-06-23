package org.tony.clarke.algo.sorting;

public class ThreeNumberSort {

    public static void main(String args[]) {
        ThreeNumberSort threeNumberSort = new ThreeNumberSort();
        threeNumberSort.threeNumberSort(new int[]{}, new int[]{0, 7, 9});
    }

    public int[] threeNumberSort(int[] array, int[] order) {

        // keep order[0] to left and put order[2] to the right...what's left in the middle will just be right
        int progressedIndex = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] == order[0]) {
                // swap with progressed index
                int temp = array[j];
                array[j] = array[progressedIndex];
                array[progressedIndex] = temp;
                progressedIndex++;
            }
        }
        progressedIndex = array.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] == order[2]) {
                // swap with progressed index
                int temp = array[j];
                array[j] = array[progressedIndex];
                array[progressedIndex] = temp;
                progressedIndex--;
            }
        }

        return array;
    }

}
