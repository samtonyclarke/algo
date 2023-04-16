package org.tony.clarke.algo.bt;

public class HeightBalancedBinaryTree {

    public static void main(String args[]) {
        HeightBalancedBinaryTree heightBalancedBinaryTree = new HeightBalancedBinaryTree();

        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
//        root.left.left.left = new BinaryTree(6);
        root.right = new BinaryTree(3);
        root.right.right = new BinaryTree(6);

        boolean b = heightBalancedBinaryTree.heightBalancedBinaryTree(root);
        System.out.println(b);
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int i = heightOfTree(tree);
        if (i < 0) {
            return false;
        } else {
            return true;
        }

    }

    private int heightOfTree(BinaryTree node) {
        if (node == null) {
            return 0;
        }
        int leftSubHeight = heightOfTree(node.left);
        int rightSubHeight = heightOfTree(node.right);

        if (Math.abs(leftSubHeight - rightSubHeight) > 1) {
            return -1;
        }
        int myHeight = Math.max(leftSubHeight, rightSubHeight) + 1;
        return myHeight;
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
