package org.tony.clarke.algo.lists;

public class LinkedListConstruction {

    public static void main(String args[]) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        Node firstHead = new Node(1);
//        Node secondHead = new Node(2);
//        doublyLinkedList.setHead(firstHead);
//        doublyLinkedList.setHead(secondHead);
//        doublyLinkedList.setHead(firstHead);
        boolean b = doublyLinkedList.containsNodeWithValue(2);
        System.out.println(b);
        b = doublyLinkedList.containsNodeWithValue(3);
        System.out.println(b);
        doublyLinkedList.insertAtPosition(1, new Node(1));
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }
            remove(node); // covers case where it might already exist
            insertBefore(this.head, node);
        }

        public void setTail(Node node) {
            if (this.tail == null) {
                this.head = node;
                this.tail = node;
                return;
            }
            remove(node); // covers case where it might already exist
            insertAfter(this.tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            remove(nodeToInsert); // covers case where node already exists
            Node tempPrior = node.prev;
            nodeToInsert.next = node;
            nodeToInsert.prev = node.prev;
            node.prev = nodeToInsert;
            if (tempPrior != null) {
                tempPrior.next = nodeToInsert;
            }
            if (node == head) {
                head = nodeToInsert; // we have a new head
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            remove(nodeToInsert); // covers case where node already exists
            Node tempNext = node.next;
            node.next = nodeToInsert;
            nodeToInsert.next = tempNext;
            nodeToInsert.prev = node;
            if (tempNext != null) {
                tempNext.prev = nodeToInsert;
            }
            if (node == tail) {
                tail = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // position of head node is 1

            if (head == null) {
                this.head = nodeToInsert;
                this.tail = nodeToInsert;
                return;
            }

            Node walker = head;
            for (int i = 1; i < position; i++) {
                walker = walker.next;
            }
            insertBefore(walker, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node walker = this.head;
            while (walker != null) {
                Node next = walker.next;
                if (walker.value == value) {
                    remove(walker);
                }
                walker = next;
            }
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next; // start from 2nd spot
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next; // just skip over
            }
            if (node.next != null) {
                node.next.prev = node.prev; // need to fix the prev pointer on the next
            }
        }

        public boolean containsNodeWithValue(int value) {
            Node walker = this.head;
            while (walker != null) {
                if (walker.value == value) {
                    return true;
                }
                walker = walker.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
