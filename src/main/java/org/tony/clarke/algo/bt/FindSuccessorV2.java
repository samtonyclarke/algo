package org.tony.clarke.algo.bt;

public class FindSuccessorV2 {

    public static void main(String args[]) {
        FindSuccessorV2 findSuccessor = new FindSuccessorV2();

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
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
        if (tree == null) {
            return null;
        }
        if (node.right != null) {
            return findLeftMostNode(node.right);
        } else {
            BinaryTree parent = node.parent;
            BinaryTree child = node;
            while(parent != null) {
                if (parent.left == child) {
                    return parent;
                }
                child = parent;
                parent = child.parent;
            }
        }
        return null;
    }

    public BinaryTree findLeftMostNode(BinaryTree node) {
        if (node.left != null) {
            return findLeftMostNode(node.left);
        } else {
            return node;
        }
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
