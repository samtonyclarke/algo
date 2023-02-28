package org.tony.clarke.algo.bt;

public class NodeDepths {

    public static void main(String args[]) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int i = nodeDepths(root);
        System.out.println(i);
    }

    public static int nodeDepths(BinaryTree root) {
        int sum = nodeDepthsInternal(root, 0);
        return sum;
    }

    public static int nodeDepthsInternal(BinaryTree node, int sum) {
        int enterSum = sum; // we should not carry over sum from one child to other child
        if (node.left != null) {
            sum += nodeDepthsInternal(node.left, enterSum + 1);
        }
        if (node.right != null) {
            sum += nodeDepthsInternal(node.right, enterSum + 1);
        }
        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
