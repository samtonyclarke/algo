package org.tony.clarke.algo.strings;

import java.util.*;
import java.util.stream.Collectors;


public class CommonCharacters {

    public static void main(String args[]) {
        CommonCharacters commonCharacters = new CommonCharacters();
        commonCharacters.commonCharacters(new String[]{"abc", "bcd", "cbaccd"});
    }

    public String[] commonCharacters(String[] strings) {

        Set<String>[] set = new HashSet[strings.length];
        for (int i = 0; i < strings.length; i++) {
            set[i] = new HashSet<>();
            for (int j = 0; j < strings[i].length(); j++) {
                set[i].add(new String(new char[]{strings[i].charAt(j)}));
            }
        }
        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < set.length; i++) {
            set[i].stream().forEach(c -> {
                counter.computeIfPresent(c, (t, r) -> r + 1);
                counter.computeIfAbsent(c, (t) -> 1);
            });
        }

        List<Map.Entry<String, Integer>> collect =
                counter.entrySet().stream().filter(kv -> kv.getValue().equals(set.length)).collect(Collectors.toList());

        String[] result = new String[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i).getKey();
        }

        return result;
    }

}
