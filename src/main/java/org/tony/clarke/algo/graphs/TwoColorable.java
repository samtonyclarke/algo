package org.tony.clarke.algo.graphs;

import java.util.Arrays;

public class TwoColorable {

    public static void main(String args[]) {

        int edges[][] = new int[][]{
                {2},
                {2, 3},
                {0, 1},
                {1}
        };

        boolean b = new TwoColorable().twoColorable(edges);
        System.out.println("Colorable: " + b);
    }

    public enum Color {
        BLUE,
        RED;

        public Color otherColor() {
            if (this == BLUE) {
                return RED;
            } else {
                return BLUE;
            }
        }
    }

    public boolean twoColorable(int[][] edges) {
        Color[] vertexColors = new Color[edges.length];
        vertexColors[0] = Color.BLUE;


        for (int i = 0; i < edges.length; i++) {
            Color fromColor = vertexColors[i];
            for (int j = 0; j < edges[i].length; j++) {
                boolean colorVertex = colorVertex(vertexColors, edges, edges[i][j], fromColor);
                if (!colorVertex) {
                    return false;
                }
                boolean allColoured = Arrays.stream(vertexColors).allMatch( vc-> vc != null);
                if (allColoured) {
                    return true;
                }
            }
        }
        return true;
    }

    private boolean colorVertex(Color[] vertexColors, int[][] edges, int vertex, Color fromColor) {
        if (vertexColors[vertex] != null) {
            if (vertexColors[vertex] == fromColor.otherColor()) {
                return true;
            }
            if (vertexColors[vertex] != fromColor.otherColor()) {
                return false; // already had a color but it's not valid now
            }
        }
        vertexColors[vertex] = fromColor.otherColor();
        for (int i = 0; i < edges[vertex].length; i++) {
            boolean colorVertex = colorVertex(vertexColors, edges, edges[vertex][i], fromColor.otherColor());
            if (!colorVertex) {
                return false;
            }
        }
        return true;
    }

}
