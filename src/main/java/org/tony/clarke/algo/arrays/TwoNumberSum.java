package org.tony.clarke.algo.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] ints = SinglePassHashSolution.twoNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
        System.out.println(Arrays.toString(ints));
    }


    class SimpleOrderNTo2 {
        public static int[] twoNumberSum(int[] array, int targetSum) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] + array[j] == targetSum) {
                        return new int[]{array[i], array[j]};
                    }
                }
            }
            return new int[0];
        }
    }

    class HashSolution {

        public static int[] twoNumberSum(int[] array, int targetSum) {
            HashMap<Integer, Integer> inputs = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                inputs.put(array[i], i);
            }
            for (int i = 0; i < array.length; i++) {
                int gap = targetSum - array[i];
                if (inputs.get(gap) != null && inputs.get(gap)!= i) {
                    return new int[] {array[i], gap};
                }
            }

            return new int[0];
        }
    }

    class SinglePassHashSolution {

        public static int[] twoNumberSum(int[] array, int targetSum) {
            HashMap<Integer, Integer> inputs = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                int gap = targetSum - array[i];
                if (inputs.get(gap) != null && inputs.get(gap)!= i) {
                    return new int[] {array[i], gap};
                }
                inputs.put(array[i], i);
            }
            return new int[0];
        }
    }
}