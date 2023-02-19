package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {
    public static void main(String[] args) {
        List<Integer[]> fourNumberSum = SimpleOrderNTo4.fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
        for (Integer[] ints : fourNumberSum) {
            System.out.println(Arrays.toString(ints));
        }
    }


    class SimpleOrderNTo4 {
        public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
            ArrayList<Integer[]> result = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    for (int k = j + 1; k < array.length; k++) {
                        for (int l = k + 1; l < array.length; l++) {
                            if (array[i] + array[j] + array[k] + array[l] == targetSum) {
                                Integer[] returning = new Integer[]{array[i], array[j], array[k], array[l]};
                                Arrays.sort(returning);
                                result.add(returning);
                            }
                        }
                    }
                }

            }
            result.sort((o1, o2) -> Arrays.compare(o1, o2));
            return result;
        }
    }
}