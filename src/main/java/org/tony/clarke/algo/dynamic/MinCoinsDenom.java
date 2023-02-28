package org.tony.clarke.algo.dynamic;

import java.util.Arrays;

public class MinCoinsDenom {

    public static void main(String args[]) {
        int i = minNumberOfCoinsForChange(7, new int[]{1, 5, 10});
        System.out.println(i);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, n + 1);
        ways[0] = 0;
        for (int i = 0; i < denoms.length; i++) {
            for (int j = 0; j < ways.length; j++) {
                if (denoms[i] <= j) {
                    ways[j] = Math.min(ways[j], 1 + ways[j - denoms[i]]);
                }
            }
        }

        if (ways[n] > n) {
            return -1;
        } else {
            return ways[n];
        }
    }
}
