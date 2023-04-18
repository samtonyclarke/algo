package org.tony.clarke.algo.bt;

import java.util.ArrayList;
import java.util.List;

public class SymmetricalTree {

    public static void main(String args[]) {

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(3);
        root.left.right = new BinaryTree(4);
        root.left.left.left = new BinaryTree(5);
        root.left.left.right = new BinaryTree(6);

        root.right = new BinaryTree(2);
        root.right.right = new BinaryTree(3);
        root.right.left = new BinaryTree(4);
        root.right.right.left = new BinaryTree(6);
        root.right.right.right = new BinaryTree(5);

        SymmetricalTree symmetricalTree = new SymmetricalTree();
        symmetricalTree.symmetricalTree(root);
    }

    public boolean symmetricalTree(BinaryTree tree) {
        ArrayList<BinaryTree> visitedLeft = new ArrayList<>();
        ArrayList<BinaryTree> visitedRight = new ArrayList<>();

        visitRightToLeft(tree.left, visitedLeft);
        visitLeftToRight(tree.right, visitedRight);
        if (visitedLeft.size() != visitedRight.size()) {
            return false;
        }
        for (int i = 0; i < visitedRight.size(); i++) {
            if (visitedLeft.get(i).value != visitedRight.get(i).value) {
                return false;
            }
        }
        return true;
    }

    private void visitRightToLeft(BinaryTree tree, ArrayList<BinaryTree> visited) {
        if (tree == null) {
            return;
        }
        visitRightToLeft(tree.right, visited);
        visited.add(tree);
        visitRightToLeft(tree.left, visited);
    }

    private void visitLeftToRight(BinaryTree tree, ArrayList<BinaryTree> visited) {
        if (tree == null) {
            return;
        }
        visitLeftToRight(tree.left, visited);
        visited.add(tree);
        visitLeftToRight(tree.right, visited);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
