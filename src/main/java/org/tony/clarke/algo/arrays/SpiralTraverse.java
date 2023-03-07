package org.tony.clarke.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String args[]) {
        int[][] array = new int[][]{
                {1},
                {12},
                {11},
                {10},
                {9}
        };
        List<Integer> spiralTraverse = spiralTraverse(array);
        spiralTraverse.forEach(i -> {
            System.out.println(i);
        });
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> integers = new ArrayList<>();
        int startX = 0;
        int endX = array[0].length;
        int startY = 0;
        int endY = array.length;

        while (integers.size() < array.length * array[0].length) {
            // do the top horizontal line
            for (int i = startX; i < endX; i++) {
                integers.add(array[startY][i]);
            }
            // do the right vertical line
            for (int i = startY + 1; i < endY - 1; i++) {
                integers.add(array[i][endX - 1]);
            }
            // do the bottom horizontal line
            if (endY - startY > 1) { // if there is an odd number of rows then don't duplicate
                for (int i = endX - 1; i >= startX; i--) {
                    integers.add(array[endY - 1][i]);
                }
            }
            // do the left vertical line
            if (endX - startX > 1) { // if there is an odd number of columns then don't duplicate
                for (int i = endY - 2; i > startY; i--) {
                    integers.add(array[i][startX]);
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return integers;
    }
}
