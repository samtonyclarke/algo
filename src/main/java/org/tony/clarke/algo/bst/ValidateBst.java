package org.tony.clarke.algo.bst;

public class ValidateBst {

    public static void main(String args[]) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.left.right = new BST(9);
        root.left.right.left = new BST(4);
        root.left.right.right = new BST(10);

        boolean b = validateBst(root);
        System.out.println(b);
    }

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBst(BST node, int min, int max) {
        if (node == null) {
            return true; // an empty child is OK
        }
        if (node.value < min) {
            return false;
        }
        if (node.value >= max) {
            return false;
        }
        boolean leftValid = validateBst(node.left, min, node.value);
        boolean rightValid = validateBst(node.right, node.value, max);
        return leftValid && rightValid;
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
