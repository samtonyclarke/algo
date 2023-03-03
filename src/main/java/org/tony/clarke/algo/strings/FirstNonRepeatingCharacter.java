package org.tony.clarke.algo.strings;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String args[]) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        firstNonRepeatingCharacter.firstNonRepeatingCharacter("abcdcaf");
    }

    public int firstNonRepeatingCharacter(String string) {
        HashMap<String, Integer> found = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String next = string.substring(i, i + 1);
            if (found.containsKey(next)) {
                found.put(next, Integer.MAX_VALUE); // mark as bad
            } else {
                found.put(next, i);
            }
        }
        Set<Map.Entry<String, Integer>> entries = found.entrySet();
        int first = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() < first) {
                first = entry.getValue();
            }
        }
        if (first == Integer.MAX_VALUE) {
            return -1;
        } else {
            return first;
        }
    }


}
