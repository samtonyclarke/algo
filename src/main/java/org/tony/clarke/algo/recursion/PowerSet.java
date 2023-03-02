package org.tony.clarke.algo.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

    public static void main(String args[]) {
        List<List<Integer>> powerset = powerset(List.of(1, 2, 3));
        for (List<Integer> list : powerset) {
            list.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        // powerset, start small and then build on with each new element
        List<List<Integer>> collecting = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            powersetInternal(array.get(i), collecting);
        }

        List<Integer> nullList = new ArrayList<>();
        collecting.add(nullList);
        return collecting;
    }

    private static void powersetInternal(Integer addition, List<List<Integer>> collecting) {
        List<List<Integer>> augmented = new ArrayList<>();
        for (List<Integer> list : collecting) {
            ArrayList<Integer> next = new ArrayList(list);
            next.add(addition);
            augmented.add(next);
        }
        collecting.addAll(augmented);
        ArrayList<Integer> next = new ArrayList();
        next.add(addition);
        collecting.add(next);
    }
}
