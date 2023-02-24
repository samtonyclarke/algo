package org.tony.clarke.algo.dynamic;

public class MaxSubsetNonAdjacent {


    public static void main(String args[]) {
        int maxSum = maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135});
        System.out.println(maxSum);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // either skip 1 or skip 2

        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Integer.max(array[0], array[1]);
        }

        int asWeGo[] = new int[array.length];
        asWeGo[0] = array[0];
        asWeGo[1] = Integer.max(array[0], array[1]);
        asWeGo[2] = Integer.max(array[1], array[0] + array[2]);

        for (int i = 3; i < array.length; i++) {
            asWeGo[i] = Integer.max(
                    Integer.max(asWeGo[i - 1], asWeGo[i - 2] + array[i]),
                    // current and prior non-adjacent or prior position
                    Integer.max(asWeGo[i - 1],
                            asWeGo[i - 3] + array[i])); // current and prior-prior non-adjacent or prior position
        }
        return asWeGo[array.length - 1];
    }


//    private static int maxOf(int a, int b, int c) {
//        Integer.max(a, b);
//    }

}
