package org.tony.clarke.algo.bst;

public class ClosestInBst {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.right.left.right = new BST(14);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        int closestValueInBst = findClosestValueInBst(root, 12);
        System.out.println("Closest is: "+closestValueInBst);
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }
    public static int findClosestValueInBst(BST tree, int target, int closest) {

        if (tree == null) {
            return closest;
        }
        int currentClosest = Math.abs(target - closest);
        int thisDif = Math.abs(target - tree.value);
        if (thisDif < currentClosest) {
            closest = tree.value;
        }

        if(tree.value < target) {
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return findClosestValueInBst(tree.left, target, closest);
        }

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
