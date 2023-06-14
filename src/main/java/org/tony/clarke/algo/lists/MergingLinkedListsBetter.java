package org.tony.clarke.algo.lists;

public class MergingLinkedListsBetter {

    public static void main(String args[]) {
        MergingLinkedListsBetter mergingLinkedLists = new MergingLinkedListsBetter();
        LinkedList linkedListOne = new LinkedList(1);
        linkedListOne.next = new LinkedList(2);
        linkedListOne.next.next = new LinkedList(3);
        linkedListOne.next.next.next = new LinkedList(4);
        LinkedList linkedListTwo = new LinkedList(5);
        linkedListTwo.next = new LinkedList(3);
        linkedListTwo.next.next = new LinkedList(4);
        LinkedList linkedList = mergingLinkedLists.mergingLinkedLists(linkedListOne, linkedListTwo);
        System.out.println(linkedList.value);
    }


    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

        LinkedList startOne = linkedListOne;
        LinkedList startTwo = linkedListTwo;

        LinkedList interSectionCandidate = null;
        int wrapAroundCount = 0;
        while (startOne != null || startTwo != null) {
            if (startOne != null && startTwo != null && startOne.value == startTwo.value) {
                if (interSectionCandidate == null) {
                    interSectionCandidate = startOne;
                }
            } else {
                interSectionCandidate = null;
            }
            // we have different lengths and we want the longer list to wrap around, then start comparison again
            if (startOne == null) {
                wrapAroundCount++;
                startTwo = startTwo.next;
            } else if (startTwo == null) {
                wrapAroundCount--;
                startOne = startOne.next;
            } else {
                startOne = startOne.next;
                startTwo = startTwo.next;
            }
            if (startOne == null && startTwo == null) {
                if (wrapAroundCount > 0) {
                    startTwo = linkedListTwo;
                    while (wrapAroundCount-- > 0) {
                        startTwo = startTwo.next;
                    }
                    startOne = linkedListOne;
                } else if (wrapAroundCount < 0) {
                    startOne = linkedListOne;
                    while (wrapAroundCount++ < 0) {
                        startOne = startOne.next;
                    }
                    startTwo = linkedListTwo;
                }
                wrapAroundCount = 0;
            }
        }
        return interSectionCandidate;
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
