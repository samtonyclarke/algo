package org.tony.clarke.algo.graphs;

public class SingleCycleCheck {

    public static void main(String args[]) {
        boolean b = hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2});
        System.out.println(b);
    }

    public static boolean hasSingleCycle(int[] array) {
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            int diff = array[next];
            next += diff;
            next = next % array.length;
            if (next < 0) {
                next = array.length + next;
            }
            if (next == 0) {
                if (i == array.length-1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
