package org.tony.clarke.algo.greedy;

import java.util.Arrays;

public class TandemBicycle {


    public static void main(String args[]) {
        TandemBicycle tandemBicycle = new TandemBicycle();
        int sum = tandemBicycle.tandemBicycle(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, true);
        System.out.println(sum);
    }

    // tandem speed is max of A or B
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int sum = 0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        // pair biggest with smallest
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (fastest) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - 1 - i]);
            } else {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return sum;
    }

}
