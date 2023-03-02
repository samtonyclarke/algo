package org.tony.clarke.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsInPlace {

    public static void main(String args[]) {
        List<List<Integer>> permutations = getPermutations(new ArrayList(Arrays.asList(1, 2, 3)));
        for (List<Integer> list : permutations) {
            list.forEach(i -> System.out.printf(String.valueOf(i)));
            System.out.println();
        }
    }


    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<List<Integer>> toReturn = new ArrayList<>();
        generator(0, array, toReturn);
        return toReturn;
    }

    private static void generator(int i, List<Integer> array, ArrayList<List<Integer>> toReturn) {
        if (i == array.size()) {
            toReturn.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(i, j, array);
                generator(i+1, array, toReturn);
                swap(i, j, array);
            }
        }
    }

    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
