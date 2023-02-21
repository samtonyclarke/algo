package org.tony.clarke.algo.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSums {

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree(1);
        bt.left = new BinaryTree(2);
        bt.right = new BinaryTree(3);
        bt.left.left = new BinaryTree(4);
        bt.left.right = new BinaryTree(5);
        bt.left.right.left = new BinaryTree(10);
        bt.left.left.left = new BinaryTree(8);
        bt.left.left.right = new BinaryTree(9);
        bt.right.left = new BinaryTree(6);
        bt.right.right = new BinaryTree(7);
        List<Integer> branchSums = branchSums(bt);
        for (Integer branchSum : branchSums) {
            System.out.println(branchSum);
        }
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> sums = new ArrayList<>();

        branchSumsInternal(root, sums, 0);

        // Write your code here.
        return sums;
    }

    public static void branchSumsInternal(BinaryTree root, List<Integer> sums, int sumSoFar) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sums.add(sumSoFar + root.value); // leaf node...can go no further
            return;
        }
        branchSumsInternal(root.left, sums, sumSoFar + root.value);
        branchSumsInternal(root.right, sums, sumSoFar + root.value);
    }
}
