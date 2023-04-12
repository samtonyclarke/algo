package org.tony.clarke.algo.bt;

public class TreeDiameter {
    // This is an input class. Do not edit.

    public static void main(String args[]) {
        TreeDiameter treeDiameter = new TreeDiameter();
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(7);
        root.left.right = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);
        root.left.right.right = new BinaryTree(5);
        root.left.right.right.right = new BinaryTree(6);

        int binaryTreeDiameter = treeDiameter.binaryTreeDiameter(root);
        System.out.println(binaryTreeDiameter);
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        Pair pair = binaryTreeDiameterPair(tree);
        return pair.longestSoFar;
    }

    private Pair binaryTreeDiameterPair(BinaryTree tree) {
        if (tree == null) {
            return new Pair(0, 0);
        }
        Pair left = binaryTreeDiameterPair(tree.left);
        Pair right = binaryTreeDiameterPair(tree.right);

        int height = Math.max(left.height, right.height) + 1; // we are recursing back out...so our height is one higher than whatever the tallest child is
        // longestSoFar just keeps track of what the longest path available is so far...when finished traversing it will have the longest of all
        int longestSoFar = Math.max(left.height + right.height, Math.max(left.longestSoFar, right.longestSoFar));
        Pair toReturn = new Pair(height, longestSoFar);
        return toReturn;
    }

    private static class Pair {
        Pair(int height, int longestSoFar) {
            this.height = height;
            this.longestSoFar = longestSoFar;
        }

        int height;
        int longestSoFar;
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
