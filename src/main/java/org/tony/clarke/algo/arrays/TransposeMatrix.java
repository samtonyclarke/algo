package org.tony.clarke.algo.arrays;

public class TransposeMatrix {

    public static void main(String args[]) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();

        int[][] matrix = new int[][]{
                {1, 2}
        };

        int[][] transposedMatrix = transposeMatrix.transposeMatrix(matrix);
    }

    public int[][] transposeMatrix(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
