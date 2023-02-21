package org.tony.clarke.algo.bst;


public class BstConstruction {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.insert(5);
        root.insert(15);
        root.remove(5);
        root.remove(15);
        root.remove(10);
//        root.insert(2);
//        root.insert(5);
//        root.insert(13);
//        root.insert(22);
//        root.insert(1);
//        root.insert(14);
//        root.insert(12);
//        root.remove(10);
//        root.contains(15);

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {
            if (this.value == value) {
                return true;
            }
            if (value >= this.value) {
                if (this.right != null) {
                    return this.right.contains(value);
                }
            } else {
                if (this.left != null) {
                    return this.left.contains(value);
                }
            }
            return false;
        }

        public BST remove(int value) {
            BST bst = removeInternal(value);
            if(bst == null) {
                return null;
            }
            this.right = bst.right;
            this.left = bst.left;
            this.value = bst.value;
            return this;
        }

        public BST removeInternal(int value) {
            // cases to support
            // 1. leaf node
            // 2. one child node
            // 3. two child nodes

            if (this.value == value) {
                if (this.left == null && this.right == null) {
                    return null; // leaf node
                } else if (this.left != null && this.right == null) {
                    // return this child to replace the parent, thereby assign parents child to be this child, allowing us to skip the value
                    return this.left;
                } else if (this.right != null && this.left == null) {
                    // return this child to replace the parent, thereby assign parents child to be this child, allowing us to skip the value
                    return this.right;
                } else { // a node with two children
                    // this value should become the smallest of the right side, then we need to remove from the subtree that smallest node
                    BST smallestNode = findSmallestNode(this.right);
                    this.value = smallestNode.value;
                    BST bst = this.right.removeInternal(smallestNode.value);
                    this.right = bst;
                    return this;
                }
            }
            if (value >= this.value) {
                if (this.right != null) {
                    BST bst = this.right.removeInternal(value);
                    this.right = bst;
                }
            } else {
                if (this.left != null) {
                    BST bst = this.left.removeInternal(value);
                    this.left = bst;
                }
            }
            return this;
        }

        private static BST findSmallestNode(BST node) {
            if (node.left != null) {
                return findSmallestNode(node.left);
            }
            return node;
        }
    }
}
