package org.tony.clarke.algo.graphs;

import java.util.ArrayList;
import java.util.List;

public class Dfs {


    public static void main(String args[]){
        Node a = new Node("A");
        a.addChild("B");

        ArrayList<String> collected = new ArrayList<>();
        List<String> searchOrder = a.depthFirstSearch(collected);
        for (String next : searchOrder) {
            System.out.println(next);
        }
    }


    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for (Node child: children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        public List<String> depthFirstSearchInternal(List<String> array) {

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
