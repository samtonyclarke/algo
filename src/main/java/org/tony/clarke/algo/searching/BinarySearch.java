package org.tony.clarke.algo.searching;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String args[]) {
        int i = binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(i);
    }

    public static int binarySearch(int[] array, int target) {
        return binarySearchInternal(array, target, 0, array.length - 1);
    }

    private static int binarySearchInternal(int[] array, int target, int left, int right) {
        if (right - left == 1) {
            if (array[left] == target) {
                return left;
            }
            if (array[right] == target) {
                return right;
            }
            return -1;
        }

        int midpoint = (right + left) / 2;

        if (array[midpoint] > target) {
            return binarySearchInternal(array, target, left, midpoint);
        } else if (array[midpoint] < target) {
            return binarySearchInternal(array, target, midpoint, right);
        } else {
            return midpoint;
        }
    }
}
