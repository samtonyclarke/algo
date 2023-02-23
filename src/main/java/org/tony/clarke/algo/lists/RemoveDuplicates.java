package org.tony.clarke.algo.lists;

public class RemoveDuplicates {

    public static void main(String args[]) {
        LinkedList node = new LinkedList(1);
        node.next = new LinkedList(1);
        node.next.next = new LinkedList(3);
        node.next.next.next = new LinkedList(4);
        node.next.next.next.next = new LinkedList(4);
        node.next.next.next.next.next = new LinkedList(4);
        node.next.next.next.next.next.next = new LinkedList(5);
        node.next.next.next.next.next.next.next = new LinkedList(6);
        node.next.next.next.next.next.next.next.next = new LinkedList(6);
        LinkedList linkedList = new RemoveDuplicates().removeDuplicatesFromLinkedList(node);
        LinkedList pointer = linkedList;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList pointer = linkedList;
        while (pointer != null) {
            pointer.next = getNextUniqueNode(pointer.next, pointer.value);
            pointer = pointer.next;
        }
        return linkedList;
    }

    private LinkedList getNextUniqueNode(LinkedList next, int value) {
        LinkedList pointer = next;
        while (pointer != null && pointer.value == value) {
            pointer = pointer.next;
        }
        return pointer;
    }
}
