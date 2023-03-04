package org.tony.clarke.algo.arrays;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String args[]) {
        NonConstructibleChange nonConstructibleChange = new NonConstructibleChange();
        int i = nonConstructibleChange.nonConstructibleChange(new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(i);
    }

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int runningSum = 0;
        for (int i = 0; i < coins.length; i++) {
            // the first number that is bigger than the current sum signals the minimum lowest sum we cannot reach
            // why? imagine been given coins [1,2]..this allows 1, 2, 3. Max sum is 3. If the next coin is 5...then
            // there must be a gap at 4. As long as you don't introduce a gap we are good!
            if (coins[i] > runningSum + 1) {
                return runningSum + 1;
            }
            runningSum += coins[i];
        }
        return runningSum + 1;
    }
}
