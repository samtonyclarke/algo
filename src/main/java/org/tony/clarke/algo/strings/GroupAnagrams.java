package org.tony.clarke.algo.strings;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GroupAnagrams {

    public static void main(String args[]) {
        List<List<String>> lists = groupAnagrams(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        lists.stream().forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        ArrayList<List<String>> anagramLists = new ArrayList();
        for (int i = 0; i < words.size(); i++) {
            List<String> anagramList = findOrCreateAnagramList(anagramLists, words.get(i));
            anagramList.add(words.get(i));
        }

        return anagramLists;
    }

    private static List<String> findOrCreateAnagramList(ArrayList<List<String>> anagramList, String nextWord) {

        for (int i = 0; i < anagramList.size(); i++) {
            if (anagramList.get(i).get(0).length() != nextWord.length()) {
                continue;
            }
            if (isAnagram(anagramList.get(i).get(0), nextWord)) {
                return anagramList.get(i);
            }
        }

        ArrayList<String> next = new ArrayList<>();
        anagramList.add(next);
        return next;

    }

    private static boolean isAnagram(String a, String b) {

        int count[] = new int[256];
        for (int i = 0;
             i < a.length(); i++) { // if we have an equal count of all characters then count of each will stay at zero
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
