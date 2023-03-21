package org.tony.clarke.algo.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

    public static void main(String args[]) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        List<Integer> integers = inOrderTraverse(root, new ArrayList<>());
        integers.forEach(i -> {
            System.out.print(i + " ");
        });
    }

    public static List<Integer> inOrderTraverse(BST node, List<Integer> array) {
        if (node == null) {
            return array;
        }
        inOrderTraverse(node.left, array);
        array.add(node.value);
        inOrderTraverse(node.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST node, List<Integer> array) {
        if (node == null) {
            return array;
        }
        array.add(node.value);
        preOrderTraverse(node.left, array);
        preOrderTraverse(node.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST node, List<Integer> array) {
        if (node == null) {
            return array;
        }
        postOrderTraverse(node.left, array);
        postOrderTraverse(node.right, array);
        array.add(node.value);
        return array;
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
