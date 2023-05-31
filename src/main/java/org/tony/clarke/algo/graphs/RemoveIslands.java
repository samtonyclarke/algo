package org.tony.clarke.algo.graphs;

public class RemoveIslands {

    public static void main(String args[]) {

        RemoveIslands removeIslands = new RemoveIslands();

        int matrix[][] = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        int[][] ints = removeIslands.removeIslands(matrix);

    }

    public int[][] removeIslands(int[][] matrix) {

        // top row
        for (int x = 0; x < matrix[0].length; x++) {
            markReachable(matrix, 1, -1, x, 0);
        }
        // bottom row
        for (int x = 0; x < matrix[0].length; x++) {
            markReachable(matrix, 1, -1, x, matrix.length - 1);
        }
        // left side
        for (int y = 0; y < matrix.length; y++) {
            markReachable(matrix, 1, -1, 0, y);
        }
        // right side
        for (int y = 0; y < matrix.length; y++) {
            markReachable(matrix, 1, -1, matrix[0].length - 1, y);
        }

        // now change any remaining 1 to 0
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    matrix[y][x] = 0;
                }
            }
        }

        // now change the original edges back to 1
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == -1) {
                    matrix[y][x] = 1;
                }
            }
        }

        return matrix;
    }

    public void markReachable(int[][] matrix, int testFor, int marker, int x, int y) {
        if (x < 0 || y > matrix.length - 1 || x > matrix[0].length - 1 || y < 0) {
            return;
        }
        if (matrix[y][x] == testFor) {
            matrix[y][x] = marker;
            markReachable(matrix, testFor, marker, x, y - 1); // up
            markReachable(matrix, testFor, marker, x + 1, y); // right
            markReachable(matrix, testFor, marker, x, y + 1); // down
            markReachable(matrix, testFor, marker, x - 1, y); // left
        }
    }

}
