package org.tony.clarke.algo.searching;

import java.util.Arrays;

public class SearchInSortedMatrix {

    public static void main(String args[]) {

        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };
        int[] ints = searchInSortedMatrix(matrix, 44);
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // can start at either top right or bottom left because that will allow us to eliminate an entire row or column
        // let's start in the bottom left corner

        int x = 0;
        int y = matrix.length - 1;
        while (x < matrix[0].length && y >= 0) {
            if (matrix[y][x] == target) {
                return new int[]{y, x};
            } else if (matrix[y][x] > target) {
                y--;
            } else {
                x++;
            }
        }
        return new int[]{-1, -1};
    }
}
