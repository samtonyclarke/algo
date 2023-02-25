package org.tony.clarke.algo.strings;

public class Palindrome {

    public static void main(String args[]) {
        boolean palindrome = isPalindrome("navan");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = str.length()-1; i < str.length() / 2; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
