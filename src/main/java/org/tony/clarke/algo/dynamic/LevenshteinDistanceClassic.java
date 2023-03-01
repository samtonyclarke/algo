package org.tony.clarke.algo.dynamic;

public class LevenshteinDistanceClassic {

    public static void main(String args[]) {
        int i = levenshteinDistance("biting", "mitten");
        System.out.println(i);
    }


    // allowed edits are
    // 1. insert a char
    // 2. delete a char
    // 3. replace a char
    public static int levenshteinDistance(String from, String to) {
        // let's create the 2d matrix
        int[][] dp = new int[from.length() + 1][to.length() + 1];
        // populate first row
        for (int i = 0; i < from.length() + 1; i++) {
            dp[i][0] = i;
        }
        // populate first column
        for (int i = 0; i < to.length() + 1; i++) {
            dp[0][i] = i;
        }
        // now fill row by row
        for (int i = 0; i < from.length(); i++) {
            for (int j = 0; j < to.length(); j++) {
                if (from.charAt(i) == to.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int min = min(dp[i][j], dp[i][j + 1], dp[i + 1][j]);
                    dp[i + 1][j + 1] = min + 1;
                }
            }

        }
        return dp[from.length()][to.length()];
    }


    public static int other(String str1, String str2) {
        // Write your code here.
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = -1; i < str1.length(); i++) {
            dp[i + 1][-1 + 1] = i + 1;
        }
        for (int j = -1; j < str2.length(); j++) {
            dp[-1 + 1][j + 1] = j + 1;
        }
        for (int j = 0; j < str2.length(); j++) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(1 + dp[i - 1 + 1][j + 1], 1 + dp[i + 1][j - 1 + 1]),
                            Math.min(1 + dp[i + 1][j - 1 + 1], 1 + dp[i - 1 + 1][j - 1 + 1]));
                }
            }

        }
        return dp[str1.length()][str2.length()];
    }


    private static int min(int replace, int delete, int insert) {
        return Math.min(Math.min(replace, delete), Math.min(delete, insert));
    }


}
