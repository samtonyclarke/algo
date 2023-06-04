package org.tony.clarke.algo.graphs;

import java.util.LinkedList;
import java.util.List;

public class CycleInGraph {

    public static void main(String argsp[]) {
        CycleInGraph cycleInGraph = new CycleInGraph();
//        int edges[][] = new int[][]{
//                {1, 3},
//                {2, 3, 4},
//                {0},
//                {},
//                {2, 5},
//                {}
//        };
        int edges[][] = new int[][]{
                {1, 2},
                {2},
                {1},
        };
        cycleInGraph.cycleInGraph(edges);
    }

    public boolean cycleInGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            List<Integer> walked = new LinkedList<>();
            walked.add(i);
            boolean cycle = walk(edges, walked, i);
            if (cycle) {
                return true;
            }
        }
        return false;
    }

    private boolean walk(int[][] edges, List<Integer> walked, int i) {
        for (int j = 0; j < edges[i].length; j++) {
            if (walked.get(0).equals(edges[i][j])) {
                return true;
            }
            if (walked.contains(edges[i][j])) {
                continue;
            }
            walked.add(edges[i][j]);
            if (walk(edges, walked, edges[i][j])) {
                return true;
            }
        }
        return false;
    }

}
