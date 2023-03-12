package org.tony.clarke.algo.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    public static void main(String args[]) {
        ZeroSumSubarray zeroSumSubarray = new ZeroSumSubarray();
        boolean b = zeroSumSubarray.zeroSumSubarray(new int[]{});
//        boolean b = zeroSumSubarray.zeroSumSubarray(new int[]{-5, -5, 2, 3, -2});
        System.out.println(b);
    }

    public boolean zeroSumSubarray(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        // the solution relies on trying to identify if we see the same sum reappear.
        // Then it must mean that in between those repetitions is a zero-sum.

        Set<Integer> sums = new HashSet<>();
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return true;
            }
            runningSum += nums[i];
            if (sums.contains(runningSum)) {
                return true;
            } else {
                sums.add(runningSum);
            }
        }
        if (runningSum == 0) {
            return true;
        }
        return false;
    }
}
