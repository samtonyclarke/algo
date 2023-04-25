package org.tony.clarke.algo.arrays;

public class MissingNumbers {

    public static void main(String args[]) {
        MissingNumbers missingNumbers = new MissingNumbers();
        missingNumbers.missingNumbers(new int[]{1, 4, 3});
    }

    public int[] missingNumbers(int[] nums) {
        int sum2N = sum2N(nums.length + 2);
        int shortSum = 0;
        for (int i = 0; i < nums.length; i++) {
            shortSum += nums[i];
        }
        int gap = sum2N - shortSum;
        // the missing numbers should sum to gap
        int midPoint = gap / 2;
        // one number must be to left of midpoint and the other to the right

        int leftTargetSum = sum2N(midPoint);
        int rightTargetSum = sum2N - leftTargetSum;

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= midPoint) {
                leftSum += nums[i];
            } else {
                rightSum += nums[i];
            }
        }

        int[] missing = new int[]{leftTargetSum - leftSum, rightTargetSum - rightSum};
        return missing;
    }

    private int sum2N(int n) {
        // sum of first n numbers is n(n+1)/2
        return n * (n + 1) / 2;
    }


}
