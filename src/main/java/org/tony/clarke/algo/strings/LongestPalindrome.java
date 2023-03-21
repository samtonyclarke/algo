package org.tony.clarke.algo.strings;

public class LongestPalindrome {

    public static void main(String args[]) {
        String longest = longestPalindromicSubstring("abaxyzzyxf");
        System.out.println(longest);
    }

    public static String longestPalindromicSubstring(String str) {
        // try to find the longest first
        for (int length = str.length(); length > 0; length--) {
            for (int i = 0; i + length <= str.length(); i++) {
                String toCheck = str.substring(i, i + length);
                if (isPalindrome(toCheck)) {
                    return toCheck;
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = 0;

        if (str.length() % 2 == 0) {
            i = str.length() / 2 - 1;
            j = i + 1;
        } else {
            i = str.length() / 2;
            i--;
            j = i + 2;
        }
        while (i >= 0) {
            if (str.charAt(i) == str.charAt(j)) {
                i--;
                j++;
            } else {
                return false;
            }
        }

        return true;
    }


}
