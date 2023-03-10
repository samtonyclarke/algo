package org.tony.clarke.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String args[]) {
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();

        int nums[][] = new int[][]{
                {-5, -4},
                {-4, -3},
                {-3, -2},
                {-2, -1},
                {-1, 0},
        };

        int[][] ints = mergeOverlappingIntervals.mergeOverlappingIntervals(nums);
        for (int i = 0; i < ints.length; i++) {
            Arrays.stream(ints[i]).forEach(j -> System.out.print(j + " "));
            System.out.println();
        }
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        ArrayList<int[]> pairs = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        int startInterval = intervals[0][0];
        int endInterval = intervals[0][1];
        int maxSoFar = Integer.MIN_VALUE;
        while (true) {
            if (i >= intervals.length - 1) {
                addPair(pairs, maxSoFar, startInterval, endInterval);
                break;
            } else if (intervals[i][1] < intervals[i + 1][0]) {
                // if the end of this interval is less than the start of the next interval then we must have that as an interval
                maxSoFar = addPair(pairs, maxSoFar, startInterval, endInterval);
                startInterval = intervals[i + 1][0];
            }
            endInterval = Math.max(Math.max(intervals[i + 1][1], intervals[i][1]), endInterval);
            i++;
        }

        int[][] toReturn = pairs.toArray(new int[][]{});

        return toReturn;
    }

    private int addPair(ArrayList<int[]> pairs, int maxSoFar, int start, int end) {
        if (end > maxSoFar) {
            pairs.add(new int[]{start, end});
            maxSoFar = end;
        }
        return maxSoFar;
    }

}
