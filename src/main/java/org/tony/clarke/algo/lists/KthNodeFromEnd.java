package org.tony.clarke.algo.lists;

public class KthNodeFromEnd {

    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(2);
        linkedList.next.next.next = new LinkedList(3);

        removeKthNodeFromEnd(linkedList, 4);
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList walker1 = head;
        LinkedList walker2 = head;
        for (int i = 0; i < k; i++) { // give walker2 k head start
            walker2 = walker2.next;
        }
        if (walker2 == null) { // removing first element
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(walker2.next != null) {
            walker1 = walker1.next;
            walker2 = walker2.next;
        }
        walker1.next = walker1.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
