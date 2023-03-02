package org.tony.clarke.algo.dynamic;

public class WaysToTraverseGraph {

    public static void main(String args[]) {
        WaysToTraverseGraph waysToTraverseGraph = new WaysToTraverseGraph();
        int i = waysToTraverseGraph.numberOfWaysToTraverseGraph(3, 4);
        System.out.println(i);
    }

    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[height][width];
        // at any starting position we can either go right or go down...so
        // sum is sum of width + 1 and height + 1

        // we can also fill in the initial column and initial row
        // then backfill from there back to the top right
        // value at the top left will be the answer
        // we also populate the grid from top right to bottom left and get the same answer
        ways[0][0] = 0;
        for (int i = 1; i < width; i++) {
            ways[0][i] = 1;
        }
        for (int i = 1; i < height; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                // the next value is the value above plus value before you
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[height-1][width-1];
    }


}
