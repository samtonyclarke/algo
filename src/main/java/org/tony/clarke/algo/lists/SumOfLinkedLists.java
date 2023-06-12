package org.tony.clarke.algo.lists;

public class SumOfLinkedLists {


    public static void main(String args[]) {
        SumOfLinkedLists sumOfLinkedLists = new SumOfLinkedLists();
        LinkedList linkedListOne = new LinkedList(1);
        linkedListOne.next = new LinkedList(1);
        linkedListOne.next.next = new LinkedList(1);
        //linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
        linkedListTwo.next = new LinkedList(9);
        linkedListTwo.next.next = new LinkedList(9);

        LinkedList linkedList = sumOfLinkedLists.sumOfLinkedLists(linkedListOne, linkedListTwo);
        while (linkedList != null) {
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList anchor = new LinkedList(-1);
        LinkedList prior = anchor;
        int carryOver = 0;
        while (linkedListOne != null || linkedListTwo != null) {

            int listOneValue = 0;
            if (linkedListOne != null) {
                listOneValue = linkedListOne.value;
            }

            int listTwoValue = 0;
            if (linkedListTwo != null) {
                listTwoValue = linkedListTwo.value;
            }

            int nextValue = listOneValue + listTwoValue + carryOver;
            if (nextValue > 9) {
                nextValue = nextValue - 10; // get first digit
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            LinkedList next = new LinkedList(nextValue);
            if (linkedListOne != null) {
                linkedListOne = linkedListOne.next;
            }
            if (linkedListTwo != null) {
                linkedListTwo = linkedListTwo.next;
            }
            prior.next = next;
            prior = prior.next;

        }
        if (carryOver == 1) {
            LinkedList next = new LinkedList(1);
            prior.next = next;
        }
        return anchor.next;
    }


    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


}
