package org.tony.clarke.algo.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinPassesOfMatrix {


    public static void main(String args[]) {
//        int matrix[][] = {
//                {0, -1, -3, 2, 0},
//                {1, -2, -5, -1, -3},
//                {3, 0, 0, -4, -1}
//        };
//        int matrix[][] = {
//                {-1, 0, 3 },
//                {0, -5, -6}
//        };

        int matrix[][] = {
                {0, 0, -1, -2},
                {-2, -3, 4, -1},
                {-2, -3, 1, -3},
                {-14, -15, 2, 0},
                {0, 0, 0, 0},
                {1, -1, -1, -1}
        };

        int i = new MinPassesOfMatrix().minimumPassesOfMatrix(matrix);
        System.out.println(i);
    }

    public int minimumPassesOfMatrix(int[][] matrix) {

        Integer closest[][] = new Integer[matrix.length][matrix[0].length];
        for (int y = 0; y < matrix.length; y++) {
            Arrays.fill(closest[y], -1);
        }

        HashSet<String> evaluationStack = new HashSet<>();
        int maxOfDistanceToNearestPositive = -1;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                Integer nextDistanceToNearestPositive =
                        distanceToNearestPositive(matrix, closest, x, y, evaluationStack);
                if (nextDistanceToNearestPositive != null) {
                    maxOfDistanceToNearestPositive =
                            Math.max(maxOfDistanceToNearestPositive, nextDistanceToNearestPositive);
                }
            }
        }
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (closest[y][x] != null && closest[y][x] == -1) {
                    return -1;
                }
            }
        }
        return maxOfDistanceToNearestPositive;
    }

    private Integer distanceToNearestPositive(int[][] matrix, Integer closest[][], int x, int y,
                                              Set<String> evaluationStack) {

        if (y < 0 || y > matrix.length - 1 || x < 0 || x > matrix[0].length - 1) {
            return null;
        }

        if (closest[y][x] != null && closest[y][x] > 0) {
            return closest[y][x];
        }
        if (matrix[y][x] == 0) {
            closest[y][x] = null;
            return null;
        }
        if (matrix[y][x] > 0) {
            closest[y][x] = 0;
            return 0;
        }

        if (evaluationStack.contains(x + "-" + y)) {
            return null;
        }
        try {
            evaluationStack.add(x + "-" + y);


            Integer north = distanceToNearestPositive(matrix, closest, x, y - 1, evaluationStack);
            if (north == null) {
                north = Integer.MAX_VALUE;
            }
            if (north == 0) { // shortcut since we have a direct positive neighbour
                closest[y][x] = 1;
                return 1;
            }
            Integer east = distanceToNearestPositive(matrix, closest, x + 1, y, evaluationStack);
            if (east == null) {
                east = Integer.MAX_VALUE;
            }
            if (east == 0) { // shortcut since we have a direct positive neighbour
                closest[y][x] = 1;
                return 1;
            }
            Integer south = distanceToNearestPositive(matrix, closest, x, y + 1, evaluationStack);
            if (south == null) {
                south = Integer.MAX_VALUE;
            }
            if (south == 0) { // shortcut since we have a direct positive neighbour
                closest[y][x] = 1;
                return 1;
            }
            Integer west = distanceToNearestPositive(matrix, closest, x - 1, y, evaluationStack);
            if (west == null) {
                west = Integer.MAX_VALUE;
            }
            if (west == 0) { // shortcut since we have a direct positive neighbour
                closest[y][x] = 1;
                return 1;
            }
            if (north == Integer.MAX_VALUE && south == Integer.MAX_VALUE && west == Integer.MAX_VALUE &&
                    east == Integer.MAX_VALUE) {
                return null;
            }
            Integer nearest = Math.min(Math.min(north, east), Math.min(south, west));

            closest[y][x] = nearest + 1;
            return nearest + 1;
        } finally {
            evaluationStack.remove(x + "-" + y);
        }
    }
}
