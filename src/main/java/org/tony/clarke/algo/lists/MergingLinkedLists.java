package org.tony.clarke.algo.lists;

public class MergingLinkedLists {

    public static void main(String args[]) {
        MergingLinkedLists mergingLinkedLists = new MergingLinkedLists();
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
        // first assume lists are same length
        LinkedList startOne = linkedListOne;
        int sizeOne = 0;
        LinkedList startTwo = linkedListTwo;
        int sizeTwo = 0;
        LinkedList interSectionCandidate = null;
        while (startOne != null || startTwo != null) {
            if (startOne != null && startTwo != null) {
                sizeOne++;
                sizeTwo++;
                if (startOne.value == startTwo.value) {
                    if (interSectionCandidate == null) {
                        interSectionCandidate = startOne;
                    }
                } else {
                    interSectionCandidate = null;
                }
                startOne = startOne.next;
                startTwo = startTwo.next;
            } else if (startOne != null) {
                sizeOne++;
                startOne = startOne.next;
            } else if (startTwo != null) {
                sizeTwo++;
                startTwo = startTwo.next;
            }
        }
        startOne = linkedListOne;
        startTwo = linkedListTwo;

        if (interSectionCandidate != null) {
            return interSectionCandidate;
        }
        // need to align lists such that the longer list (if exists) ends at the same point as the shorter list
        int sizeDiff = Math.abs(sizeTwo - sizeOne);
        if (sizeTwo > sizeOne) {
            while (sizeDiff-- > 0) {
                startTwo = startTwo.next;
            }
        } else {
            while (sizeDiff-- > 0) {
                startOne = startOne.next;
            }
        }
        while (startOne != null || startTwo != null) {
            if (startOne.value == startTwo.value) {
                if (interSectionCandidate == null) {
                    interSectionCandidate = startOne;
                }
            } else {
                interSectionCandidate = null;
            }
            startOne = startOne.next;
            startTwo = startTwo.next;
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
