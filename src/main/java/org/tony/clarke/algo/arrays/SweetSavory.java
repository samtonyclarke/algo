package org.tony.clarke.algo.arrays;

import java.util.Arrays;

public class SweetSavory {

    public static void main(String args[]) {
        int dishes[] = {-12, 13, 100, -53, 540, -538, 53, 76, 32, -63};
        int[] ints = new SweetSavory().sweetAndSavory(dishes, -34);
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    public int[] sweetAndSavory(int[] dishes, int target) {
        Arrays.sort(dishes);

        int i = 0, j = 0;

        for (int k = 0; k < dishes.length; k++) {
            if(dishes[k]>0) {
                i = k-1;
                j = k;
                break;
            }
        }

        int pair[] = new int[2];
        int gap = Integer.MAX_VALUE;

        while (i >= 0 && j < dishes.length) {
            if (dishes[i] + dishes[j] == target) {
                pair[0] = dishes[i];
                pair[1] = dishes[j];
                return pair;
            } else if (dishes[i] + dishes[j] > target) {
                i--;
            } else {
                int diff = target - (dishes[i] + dishes[j]);
                if (Math.abs(diff) < gap) {
                    gap = Math.abs(diff);
                    pair[0] = dishes[i];
                    pair[1] = dishes[j];
                }
                j++;
            }
        }
        return pair;
    }

}
