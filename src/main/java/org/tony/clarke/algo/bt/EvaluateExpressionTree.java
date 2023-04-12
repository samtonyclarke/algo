package org.tony.clarke.algo.bt;

public class EvaluateExpressionTree {

    public static final int ADDITION = -1;
    public static final int SUBTRACTION = -2;
    public static final int DIVISION = -3;
    public static final int MULTIPLICATION = -4;

    public static final int NULL = -5;

    public static void main(String ags[]) {
        BinaryTree root = new BinaryTree(ADDITION);
        root.left = new BinaryTree(SUBTRACTION);
        root.right = new BinaryTree(DIVISION);
        root.left.right = new BinaryTree(2);
        root.left.left = new BinaryTree(MULTIPLICATION);
        root.left.left.left = new BinaryTree(2);
        root.left.left.right = new BinaryTree(3);
        root.right.left = new BinaryTree(8);
        root.right.right = new BinaryTree(3);
        EvaluateExpressionTree evaluateExpressionTree = new EvaluateExpressionTree();
        int i = evaluateExpressionTree.evaluateExpressionTree(root);
        System.out.println(i);
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree == null) {
            return NULL;
        }
        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);

        if (left == NULL) {
            return tree.value;
        }

        return process(left, right, tree.value);
    }

    private int process(int left, int right, int operation) {
        int result = 0;
        switch (operation) {
            case ADDITION:
                result = left + right;
                break;
            case SUBTRACTION:
                result = left - right;
                break;
            case MULTIPLICATION:
                result = left * right;
                break;
            case DIVISION:
                result = left / right;
                break;
        }
        return result;
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
