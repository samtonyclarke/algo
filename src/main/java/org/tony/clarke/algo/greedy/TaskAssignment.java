package org.tony.clarke.algo.greedy;

import java.util.*;

public class TaskAssignment {

    public static void main(String args[]) {
        TaskAssignment taskAssignment = new TaskAssignment();
        ArrayList<Integer> tasks = new ArrayList();
        tasks.add(1);
        tasks.add(3);
        tasks.add(5);
        tasks.add(3);
        tasks.add(1);
        tasks.add(4);
        ArrayList<ArrayList<Integer>> arrayLists = taskAssignment.taskAssignment(3, tasks);

    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            nodes.add(new Node(i, tasks.get(i)));
        }
        nodes.sort(Comparator.comparingInt(o -> o.value));

        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();

        for (int i = 0; i < tasks.size() / 2; i++) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(nodes.get(i).index);
            pair.add(nodes.get((tasks.size() - i - 1)).index);
            toReturn.add(pair);
        }

        return toReturn;
    }

    private static class Node {
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        int index;
        int value;
    }

}
