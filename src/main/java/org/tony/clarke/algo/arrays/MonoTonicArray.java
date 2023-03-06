package org.tony.clarke.algo.arrays;

public class MonoTonicArray {

    public static void main(String args[]) {
        boolean monotonic = isMonotonic(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(monotonic);
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return true;
        }
        int oldDiff = 0;
        for (int i = 1; i < array.length; i++) {
            int newDiff = array[i] - array[i - 1];
            if (!sameSign(newDiff, oldDiff)) {
                return false;
            }
            if (newDiff != 0) {
                oldDiff = newDiff;
            }
        }
        return true;
    }


    private static boolean sameSign(int a, int b) {
        if (a < 0 && b > 0) {
            return false;
        }
        if (a > 0 && b < 0) {
            return false;
        }
        return true;
    }

}
