package org.tony.clarke.algo.bt;

import java.util.ArrayList;
import java.util.Stack;

public class SymmetricalTreeV2 {

    public static void main(String args[]) {

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(2);

        root.left.left = new BinaryTree(3);
//        root.left.right = new BinaryTree(4);
//        root.left.left.left = new BinaryTree(5);
//        root.left.left.right = new BinaryTree(6);
//
//
//        root.right.right = new BinaryTree(3);
//        root.right.left = new BinaryTree(4);
//        root.right.right.left = new BinaryTree(6);
//        root.right.right.right = new BinaryTree(5);

        SymmetricalTreeV2 symmetricalTree = new SymmetricalTreeV2();
        boolean b = symmetricalTree.symmetricalTree(root);
        System.out.println(b);
    }

    public boolean symmetricalTree(BinaryTree tree) {
        Stack<BinaryTree> leftStack = new Stack<>();
        Stack<BinaryTree> rightStack = new Stack<>();

        if (tree.left != null) {
            leftStack.push(tree.left);
        }
        if (tree.right != null) {
            rightStack.push(tree.right);
        }

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            BinaryTree left = leftStack.pop();
            BinaryTree right = rightStack.pop();
            if (left.value != right.value) {
                return false;
            }
            // left side, add left to right
            // right side, add right to left
            if (left.left != null) {
                leftStack.push(left.left);
            }
            if (left.right != null) {
                leftStack.push(left.right);
            }

            if (right.right != null) {
                rightStack.push(right.right);
            }
            if (right.left != null) {
                rightStack.push(right.left);
            }

        }

        return leftStack.isEmpty() && rightStack.isEmpty();
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
