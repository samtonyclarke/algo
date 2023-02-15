package org.example;

import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> threeNumberSum = SimpleOrderNTo3.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
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

    class HashSolution {

        public static int[] twoNumberSum(int[] array, int targetSum) {
            HashMap<Integer, Integer> inputs = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                inputs.put(array[i], i);
            }
            for (int i = 0; i < array.length; i++) {
                int gap = targetSum - array[i];
                if (inputs.get(gap) != null && inputs.get(gap) != i) {
                    return new int[]{array[i], gap};
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
                if (inputs.get(gap) != null && inputs.get(gap) != i) {
                    return new int[]{array[i], gap};
                }
                inputs.put(array[i], i);
            }
            return new int[0];
        }
    }
}