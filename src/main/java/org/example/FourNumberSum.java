package org.example;

import java.util.*;

public class FourNumberSum {
    public static void main(String[] args) {
        List<Integer[]> fourNumberSum = OrderNSquared.fourNumberSum(new int[]{5, -5, -2, 2, 3, -3}, 0);
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

    class OrderNSquared {
        public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
            TreeSet<Integer[]> result = new TreeSet<>((o1, o2) -> {
                // a duplicate can occur, to eliminate duplicates lets ensure that all entries are unique
                for (int i = 0; i <o1.length; i++) {
                    int sumComparator = Integer.compare(o1[i],o2[i]);
                    if (sumComparator != 0) {
                        return sumComparator;
                    }
                }
                return 0;
            });
            HashMap<Integer, ArrayList<Integer[]>> sumOf2 = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    ArrayList<Integer[]> sums = sumOf2.get(array[i] + array[j]);
                    if (sums == null) {
                        sumOf2.put(array[i] + array[j], new ArrayList<>());
                    }
                    sums = sumOf2.get(array[i] + array[j]);
                    sums.add(new Integer[]{i, j});
                }
            }
            for (Map.Entry<Integer, ArrayList<Integer[]>> entries : sumOf2.entrySet()) {
                int target = targetSum - entries.getKey();
                ArrayList<Integer[]> matches = sumOf2.get(target);
                if (matches != null) {
                    for (Integer[] entry : entries.getValue()) {
                        for (Integer[] match : matches) {
                            // if any index from entry exists in match then it's not a valid combo
                            Integer[] returning =
                                    new Integer[]{array[entry[0]], array[entry[1]],
                                            array[match[0]], array[match[1]]};
                            HashSet<Integer> distinct = new HashSet<>(List.of(returning));
                            if (distinct.size() != 4) {
                                continue;
                            }
                            Arrays.sort(returning);
                            result.add(returning);
                        }
                    }
                }

            }
            return new ArrayList<>(result);
        }
    }
}