package org.tony.clarke.algo.bt;

import java.util.ArrayList;
import java.util.List;

public class SplitBinaryTree {

    public static void main(String args[]) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
//        root.left.left = new BinaryTree(6);
//        root.left.right = new BinaryTree(-5);
//        root.left.left.left = new BinaryTree(2);
        root.right = new BinaryTree(1);
        root.right.right = new BinaryTree(1);
//        root.right.left = new BinaryTree(5);
//        root.right.right = new BinaryTree(2);

        SplitBinaryTree splitBinaryTree = new SplitBinaryTree();
        int i = splitBinaryTree.splitBinaryTree(root);
        System.out.println(i);
    }

    public int splitBinaryTree(BinaryTree tree) {
        List<Integer> sums = new ArrayList<>();
        int total = splitBinaryTreeInternal(tree, sums);
        if (total % 2 != 0) {
            return 0;
        }
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) == total / 2) {
                return total / 2;
            }
        }
        // Write your code here.
        return 0;
    }

    public int splitBinaryTreeInternal(BinaryTree tree, List<Integer> sums) {
        if (tree == null) {
            return 0;
        }
        int left = splitBinaryTreeInternal(tree.left, sums);
        int right = splitBinaryTreeInternal(tree.right, sums);
        sums.add(right + left + tree.value);

        // Write your code here.
        return left + right + tree.value;
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
