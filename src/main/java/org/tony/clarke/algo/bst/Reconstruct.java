package org.tony.clarke.algo.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reconstruct {

    public static void main(String args[]) {
        Reconstruct reconstruct = new Reconstruct();
        ArrayList<Integer> preOrderTraversalValues = new ArrayList<>();
        preOrderTraversalValues.addAll(List.of(2, 0, 1, 4, 3, 3));
        reconstruct.reconstructBst(preOrderTraversalValues);
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        Integer rootValue = preOrderTraversalValues.get(0);
        BST root = new BST(rootValue);
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            addChild(root, preOrderTraversalValues.get(i));
        }

        return root;
    }

    private void addChild(BST ancestor, Integer value) {
        if (value >= ancestor.value) {
            if (ancestor.right == null) {
                ancestor.right = new BST(value);
            } else {
                addChild(ancestor.right, value);
            }
        } else {
            if (ancestor.left == null) {
                ancestor.left = new BST(value);
            } else {
                addChild(ancestor.left, value);
            }
        }
    }


    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }


    public static List<Integer> preOrderTraverse(BSTTraversal.BST node, List<Integer> array) {
        if (node == null) {
            return array;
        }
        array.add(node.value);
        preOrderTraverse(node.left, array);
        preOrderTraverse(node.right, array);
        return array;
    }

}
