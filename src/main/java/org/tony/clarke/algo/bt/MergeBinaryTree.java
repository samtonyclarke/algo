package org.tony.clarke.algo.bt;

public class MergeBinaryTree {

    public static void main(String args[]) {
        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        BinaryTree root1 = new BinaryTree(1);
        root1.left = new BinaryTree(3);
        root1.left.left = new BinaryTree(7);
        root1.left.right = new BinaryTree(4);
        root1.right = new BinaryTree(2);

        BinaryTree root2 = new BinaryTree(1);
        root2.left = new BinaryTree(5);
        root2.left.left = new BinaryTree(2);
        root2.right = new BinaryTree(9);
        root2.right.left = new BinaryTree(7);
        root2.right.right = new BinaryTree(6);

        BinaryTree merge = mergeBinaryTree.mergeBinaryTrees(root1, root2);
    }

    public BinaryTree mergeBinaryTrees(BinaryTree from, BinaryTree to) {
        if (from == null) {
            return to;
        }
        if (to == null) {
            to = from;
        } else {
            to.value = to.value + from.value;
        }
        to.left = mergeBinaryTrees(from.left, to.left);
        to.right = mergeBinaryTrees(from.right, to.right);
        return to;
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
