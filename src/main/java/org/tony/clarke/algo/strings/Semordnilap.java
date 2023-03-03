package org.tony.clarke.algo.strings;

import java.util.ArrayList;

public class Semordnilap {

    public static void main(String args[]) {
        Semordnilap semordnilap = new Semordnilap();
        ArrayList<ArrayList<String>> lists =
                semordnilap.semordnilap(new String[]{"diaper", "abc", "test", "cba", "repaid"});
        for (ArrayList<String> list: lists) {
            list.forEach(s -> System.out.print(s+" "));
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {

        ArrayList<ArrayList<String>> toReturn = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isReverse(words[i], words[j])) {
                    ArrayList<String> pair = new ArrayList<>();
                    pair.add(words[i]);
                    pair.add(words[j]);
                    toReturn.add(pair);
                }
            }
        }

        return toReturn;
    }

    private boolean isReverse(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int length = first.length();
        for (int i = 0; i < length; i++) {
            if(first.charAt(i) != second.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }
}
