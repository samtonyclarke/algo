package org.tony.clarke.algo.dynamic;

public class LevenshteinDistanceBruteForce {

    public static void main(String args[]) {
        int i = levenshteinDistance("fgh", "dbc");
        System.out.println(i);
    }


    // allowed edits are
    // 1. insert a char
    // 2. delete a char
    // 3. replace a char
    public static int levenshteinDistance(String from, String to) {
        return levenshteinDistanceInternal(from, to, from.length() - 1, to.length() - 1);

    }

    public static int levenshteinDistanceInternal(String from, String to, int fromIndex, int toIndex) {
        if (fromIndex == -1) { // if we have come to end of this string then the cost, is whatever is left in the other string
            return toIndex + 1;
        }
        if (toIndex == -1) { // if we have come to end of this string then the cost, is whatever is left in the other string
            return fromIndex + 1;
        }

        if (from.charAt(fromIndex) == to.charAt(toIndex)) {
            // if we are equal the no cost and move to next character
            return levenshteinDistanceInternal(from, to, fromIndex - 1, toIndex - 1);
        }
        // otherwise try all other combinations
        int insert = 1 + levenshteinDistanceInternal(from, to, fromIndex, toIndex - 1);
        int delete = 1 + levenshteinDistanceInternal(from, to, fromIndex - 1, toIndex);
        int replace = 1 + levenshteinDistanceInternal(from, to, fromIndex - 1, toIndex - 1);
        return Math.min(Math.min(delete, insert), Math.min(delete, replace)); // minimum of all three wins
    }
}
