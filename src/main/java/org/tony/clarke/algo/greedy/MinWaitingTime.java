package org.tony.clarke.algo.greedy;

import java.util.Arrays;

public class MinWaitingTime {

    public static void main(String[] args) {
        int min = new MinWaitingTime().minimumWaitingTime(new int[]{3, 2, 1, 2, 6});
        System.out.println("Minimum waiting time is: " + min);
    }

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;
        for (int i = 1; i < queries.length; i++) {
            sum += queries[i-1] * (queries.length-i);
        }
        return sum;
    }

}
