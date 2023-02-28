package org.tony.clarke.algo.strings;

public class CaesarCipherEncryptor {

    public static void main(String args[]) {
        String encrypted = caesarCypherEncryptor("xyz", 2);
        System.out.println(encrypted);
    }

    public static String caesarCypherEncryptor(String str, int key) {
        char a = 'a';
        char z = 'z';
        int range = z - a;
        range++;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] + key <= 'z') {
                chars[i] = (char) (chars[i] + key);
            } else {
                int mod = ((chars[i] - a + key) % range);
                chars[i] = (char) ('a' + mod);
            }
        }
        return new String(chars);
    }
}
