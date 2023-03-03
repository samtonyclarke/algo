package org.tony.clarke.algo.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

    public static void main(String args[]) {
        boolean validSubsequence =
                isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10),
                        Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10, 12));
        System.out.println(validSubsequence);
    }


    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int i = 0;
        int j = 0;
        int toMatch = sequence.size();
        while (i < sequence.size()) {
            int si = sequence.get(i);
            while (j < array.size()) {
                int aj = array.get(j);
                if (aj == si) {
                    i++;
                    j++;
                    toMatch--;
                    if (toMatch == 0) {
                        return true;
                    }
                    break;
                }
                j++;
            }
            if (j == array.size()) {
                return false;
            }
        }
        return false;
    }
}
