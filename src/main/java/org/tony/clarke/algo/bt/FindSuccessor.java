package org.tony.clarke.algo.bt;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {

    public static void main(String args[]) {
        FindSuccessor findSuccessor = new FindSuccessor();

        BinaryTree root = new FindSuccessor.BinaryTree(1);
        root.left = new FindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(5);
        root.right.parent = root;
        root.right.right = new BinaryTree(6);
        root.right.right.parent = root.right;
        root.right.right.left = new BinaryTree(7);
        root.right.right.left.parent = root.right.right;

        BinaryTree successor = findSuccessor.findSuccessor(root, root);
        System.out.println(successor.value);
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        ArrayList<BinaryTree> visited = new ArrayList<>();
        findSuccessor(tree, node, visited);
        for (int i = 0; i < visited.size()-1; i++) {
            if (visited.get(i) == node) {
                return visited.get(i+1);
            }
        }
        return null;
    }

    public void findSuccessor(BinaryTree tree, BinaryTree node, List<BinaryTree> visited) {
        if (tree == null) {
            return;
        }

        findSuccessor(tree.left, node, visited);
        System.out.println(tree.value);
        // in order work
        visited.add(tree);
        findSuccessor(tree.right, node, visited);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
