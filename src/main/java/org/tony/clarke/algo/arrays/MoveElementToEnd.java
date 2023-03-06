package org.tony.clarke.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String args[]) {
        List<Integer> integers = moveElementToEnd(Arrays.asList(3, 3, 3, 3, 3), 3);
        integers.forEach(i -> System.out.println(i));

    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // find start and end index to swap, then keep going until they overlap
        int i = 0;
        int j = array.size() - 1;

        while (i < j) {
            while (array.get(j) == toMove && j > 0) {
                j--;
            }
            while (array.get(i) != toMove && i < array.size() - 1) {
                i++;
            }
            swap(array, i, j);
        }
        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        if (i > j) {
            return;
        }
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
