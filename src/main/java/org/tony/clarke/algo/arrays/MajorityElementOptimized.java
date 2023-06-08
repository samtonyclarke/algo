package org.tony.clarke.algo.arrays;

public class MajorityElementOptimized {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 2, 3, 2, 2, 4, 2};
        int i = new MajorityElementOptimized().majorityElement(array);
        System.out.println(i);
    }

    public int majorityElement(int[] array) {
        int candidate = array[0];
        int encountered = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == candidate) {
                encountered++;
            } else {
                encountered--;
            }
            if (encountered == 0) {
                candidate = array[j+1];
            }
        }
        if (encountered > 0) {
            return candidate;
        }
        return -1;
    }
}
