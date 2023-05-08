package org.tony.clarke.algo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

    public static void main(String args[]) {
        Node root = new Node("A");
        Node B = root.addChild("B");
        root.addChild("C");
        Node D = root.addChild("D");
        B.addChild("E");
        Node F = B.addChild("F");
        Node G = D.addChild("G");
        D.addChild("H");
        F.addChild("I");
        F.addChild("J");
        G.addChild("K");
        List<String> bfs = new ArrayList<>();
        root.breadthFirstSearch(bfs);
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // BFS is modelled as a queue, DFS as stack
            List<Node> toVisit = new ArrayList<>();
            toVisit.add(this);
            while(!toVisit.isEmpty()) {
                Node next = toVisit.remove(0);
                array.add(next.name);
                toVisit.addAll(next.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
