package org.tony.clarke.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String args[]) {
        List<List<Integer>> permutations = getPermutations(Arrays.asList(1, 2, 3));
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
        generator(array, new ArrayList<>(), toReturn);
        return toReturn;
    }

    private static void generator(List<Integer> remaining, List<Integer> buildingPermutation, ArrayList<List<Integer>> toReturn) {
        if (remaining.isEmpty()) {
            toReturn.add(new ArrayList<>(buildingPermutation));
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                // all the possibilities beginning with the ith character
                List<Integer> nextRemaining = new ArrayList<>(remaining);
                Integer removed = nextRemaining.remove(i);
                List<Integer> nextBuildingPermutation = new ArrayList<>(buildingPermutation);
                nextBuildingPermutation.add(removed);
                generator(nextRemaining, nextBuildingPermutation, toReturn);
            }
        }
    }

}
