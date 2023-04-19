package org.tony.clarke.algo.arrays;

public class BestSeat {

    public static void main(String args[]) {
        BestSeat bestSeat = new BestSeat();
//        int i = bestSeat.bestSeat(new int[]{1, 0, 0, 1});
        int i = bestSeat.bestSeat(new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1});
//        int i = bestSeat.bestSeat(new int[]{1, 0, 1, 0, 0, 0, 1});
        System.out.println(i);
    }

    public int bestSeat(int[] seats) {
        int startRange = -1;
        int maxStartRange = -1;
        int maxSizeSoFar = 0;
        int size = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) { // free space
                if (size == 0) {
                    startRange = i;
                }
                size++;
            } else { // occupied
                if (size > maxSizeSoFar) {
                    maxSizeSoFar = size;
                    maxStartRange = startRange;
                }
                size = 0;
            }
        }
        if (maxSizeSoFar == 0) {
            return -1;
        } else {
            int offset = (int) (Math.floor(maxSizeSoFar / 2));
            if (maxSizeSoFar % 2 == 0) {
                offset--;
            }
            return maxStartRange + offset;
        }
    }

}
