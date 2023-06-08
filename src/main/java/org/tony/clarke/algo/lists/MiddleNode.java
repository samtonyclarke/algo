package org.tony.clarke.algo.lists;

public class MiddleNode {

    public static void main(String args[]) {
        MiddleNode middleNode = new MiddleNode();
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
//        linkedList.next.next.next = new LinkedList(4);
        middleNode.middleNode(linkedList);
    }

    public LinkedList middleNode(LinkedList linkedList) {
        // find the midpoint....setup two racers...s2 twice as fast as s1...when s2 gets to the end s1 is at the midpoint
        LinkedList s1 = linkedList;
        LinkedList s2 = linkedList;
        while(s2!= null && s2.next != null) {
            s1 = s1.next;
            s2 = s2.next;
            if (s2 != null) {
                s2 = s2.next;
            }
        }
        return s1;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
