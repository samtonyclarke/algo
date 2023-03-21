package org.tony.clarke.algo.bst;

import java.util.ArrayList;

public class FindKLargest {

    public static void main(String args[]) {
        FindKLargest findKLargest = new FindKLargest();

        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        root.left.right = new BST(5);
        root.left.left = new BST(2);
        root.left.left.right = new BST(3);
        root.left.left.left = new BST(1);

        int kthLargestValueInBst = findKLargest.findKthLargestValueInBst(root, 3);
        System.out.println(kthLargestValueInBst);
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        reverseVisitInOrder(inOrder, tree, k);
        return inOrder.get(inOrder.size()-1);
    }

    public void reverseVisitInOrder(ArrayList<Integer> gather, BST node, int k) {
        if (node == null || gather.size() == k) {
            return;
        }
        reverseVisitInOrder(gather, node.right, k);
        if (gather.size() == k) {
            return;
        }
        gather.add(node.value);
        reverseVisitInOrder(gather, node.left, k);
    }


    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

}
