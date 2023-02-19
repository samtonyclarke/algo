package org.example;

import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> threeNumberSum = OrderNSquared.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        for (Integer[] ints : threeNumberSum) {
            System.out.println(Arrays.toString(ints));
        }
    }


    class SimpleOrderNTo3 {
        public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            ArrayList<Integer[]> result = new ArrayList();
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[i] + array[j] + array[k] == targetSum) {
                            Integer[] returning = new Integer[]{array[i], array[j], array[k]};
                            Arrays.sort(returning);
                            result.add(returning);
                        }
                    }
                }
            }
            result.sort((o1, o2) -> Arrays.compare(o1, o2));
            return result;
        }
    }

    class OrderNSquared {

        public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
            Arrays.sort(array);

            ArrayList<Integer[]> result = new ArrayList();
            for (int i = 0; i < array.length; i++) {
                int l = i + 1;
                int r = array.length-1;
                while (r > l) {
                    int currentSum = array[i] + array[l] + array[r];
                    if (currentSum == targetSum) {
                        result.add(new Integer[]{array[i], array[l], array[r]});
                        r--;
                        l++;
                    } else if (currentSum > targetSum) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

            return result;
        }
    }
}