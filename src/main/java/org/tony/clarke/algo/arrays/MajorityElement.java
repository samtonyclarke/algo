package org.tony.clarke.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 2, 3, 2, 2, 4, 2};
        int i = new MajorityElement().majorityElement(array);
        System.out.println(i);
    }

    public int majorityElement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int candidate = array[i];
            int encountered = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == candidate) {
                    encountered++;
                } else {
                    encountered--;
                }
            }
            if (encountered > 0) {
                return candidate;
            }
        }

        return -1;
    }
}
