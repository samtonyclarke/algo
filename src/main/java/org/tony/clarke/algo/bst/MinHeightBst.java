package org.tony.clarke.algo.bst;

import java.util.Arrays;
import java.util.List;

public class MinHeightBst {

    public static void main(String args[]) {
        BST bst = minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
    }

    public static BST minHeightBst(List<Integer> array) {
        int rootIndex = array.size() / 2;
        BST root = new BST(array.get(rootIndex));
        minHeightBstInternal(root, array, 0, rootIndex-1);
        minHeightBstInternal(root, array, rootIndex+1, array.size()-1);
        return root;
    }

    public static void minHeightBstInternal(BST node, List<Integer> array, int left, int right) {
        if (left > right) {
            return;
        }
        int midPoint = (left + right) / 2;
        node.insert(array.get(midPoint));
        minHeightBstInternal(node, array, left, midPoint - 1);
        minHeightBstInternal(node, array, midPoint + 1, right);
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
