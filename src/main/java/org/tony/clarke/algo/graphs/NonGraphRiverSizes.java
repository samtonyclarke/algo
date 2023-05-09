package org.tony.clarke.algo.graphs;

import java.util.ArrayList;
import java.util.List;

public class NonGraphRiverSizes {

    public static void main(String args[]) {
        int matrix[][] = new int[][]{
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };
        List<Integer> riverSizes = riverSizes(matrix);
        riverSizes.stream().forEach(i -> System.out.println(i));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // non graph solution
        List<Integer> riverSizes = new ArrayList<>();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                int southExpanse = expandSouthFrom(matrix, y, x);
                int eastExpanse = expandEastFrom(matrix, y, x);
                int northExpanse = expandNorthFrom(matrix, y, x);
                int westExpanse = expandWestFrom(matrix, y, x);
                if (southExpanse > 0) {
                    riverSizes.add(southExpanse);
                }
                if (eastExpanse > 0) {
                    riverSizes.add(eastExpanse);
                }
                if (northExpanse > 0) {
                    riverSizes.add(northExpanse);
                }
                if (westExpanse > 0) {
                    riverSizes.add(westExpanse);
                }

                if (matrix[y][x] == 1) { // just one on its own
                    matrix[y][x] = 0;
                    riverSizes.add(1);
                }
            }
        }
        return riverSizes;
    }

    private static int expandEastFrom(int[][] matrix, int y, int x) {
        int expanse = 0;
        while (x < matrix[0].length) {
            if (matrix[y][x] == 1) {
                matrix[y][x] = 0;
                expanse++;
                expanse += expandNorthFrom(matrix, y - 1, x);
                expanse += expandSouthFrom(matrix, y + 1, x);
                expanse += expandWestFrom(matrix, y, x - 1);
                x++;
            } else {
                break;
            }
        }
        return expanse;
    }

    private static int expandWestFrom(int[][] matrix, int y, int x) {
        int expanse = 0;
        while (x >= 0) {
            if (matrix[y][x] == 1) {
                matrix[y][x] = 0;
                expanse++;
                expanse += expandNorthFrom(matrix, y - 1, x);
                expanse += expandEastFrom(matrix, y, x + 1);
                expanse += expandSouthFrom(matrix, y + 1, x);
                x--;
            } else {
                break;
            }

        }

        return expanse;
    }

    private static int expandSouthFrom(int[][] matrix, int y, int x) {
        int expanse = 0;
        while (y < matrix.length) {
            if (matrix[y][x] == 1) {
                matrix[y][x] = 0;
                expanse++;
                expanse += expandNorthFrom(matrix, y - 1, x);
                expanse += expandEastFrom(matrix, y , x + 1);
                expanse += expandWestFrom(matrix, y, x - 1);
                y++;
            } else {
                break;
            }
        }

        return expanse;
    }

    private static int expandNorthFrom(int[][] matrix, int y, int x) {
        int expanse = 0;
        while (y >= 0) {
            if (matrix[y][x] == 1) {
                matrix[y][x] = 0;
                expanse++;
                expanse += expandEastFrom(matrix, y, x + 1);
                expanse += expandSouthFrom(matrix, y + 1, x);
                expanse += expandWestFrom(matrix, y, x - 1);
                y--;
            } else {
                break;
            }

        }

        return expanse;
    }

}
