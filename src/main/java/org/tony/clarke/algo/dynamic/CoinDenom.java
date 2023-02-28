package org.tony.clarke.algo.dynamic;


public class CoinDenom {

    public static void main(String args[]) {
        int i = numberOfWaysToMakeChange(6, new int[]{1, 5});
        System.out.println(i);
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int i = 0; i < denoms.length; i++) {
            for (int j = 0; j < ways.length; j++) {
                if (denoms[i] <= j) {
                    ways[j] += ways[j - denoms[i]];
                }
            }
        }
        return ways[n];
    }

}


