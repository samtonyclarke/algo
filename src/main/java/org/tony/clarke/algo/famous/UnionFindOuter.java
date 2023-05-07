package org.tony.clarke.algo.famous;

import java.util.HashMap;
import java.util.Map;

public class UnionFindOuter {

    public static void main(String args[]) {
        UnionFind unionFind = new UnionFind();
        unionFind.createSet(3);
        unionFind.createSet(12);
        unionFind.find(5);
        unionFind.createSet(2);
        unionFind.createSet(1000);
        unionFind.union(1000, 2);
        unionFind.union(1000, 5);
        unionFind.union(1, 12);
        unionFind.createSet(7);
        unionFind.union(3, 5);
        unionFind.union(7, 3);
        unionFind.find(1);
        unionFind.find(3);
    }

    static class UnionFind {

        private Map<Integer, Integer> value2Rep = new HashMap<>();

        public void createSet(int value) {
            value2Rep.put(value, value);
        }

        public Integer find(int value) {
            if (value2Rep.containsKey(value)) {
                return value2Rep.get(value);
            } else {
                return null;
            }
        }

        public void union(int valueOne, int valueTwo) {
            // let's add all values from set of value two to set of value one
            Integer representativeOfValueOne = find(valueOne);
            Integer representativeOfValueTwo = find(valueTwo);
            if (representativeOfValueOne == null || representativeOfValueTwo == null) {
                return;
            }

            for (Map.Entry<Integer, Integer> mapEntry : value2Rep.entrySet()) {
                if (mapEntry.getValue().equals(representativeOfValueTwo)) {
                    value2Rep.put(mapEntry.getKey(), representativeOfValueOne);
                }
            }
        }
    }

}
