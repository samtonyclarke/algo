package org.tony.clarke.algo.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StairCaseTraversal {

    public static void main(String args[]) {
        StairCaseTraversal stairCaseTraversal = new StairCaseTraversal();
        int i = stairCaseTraversal.staircaseTraversal(4, 2);
        System.out.println(i);
    }

    public int staircaseTraversal(int height, int maxSteps) {
        int howManyStepsAtATime[] = new int[maxSteps];
        for (int i = 1; i <= maxSteps; i++) {
            howManyStepsAtATime[i - 1] = i;
        }

        Set<List<Integer>> solutions = new HashSet<>();
        search(solutions, 0, new ArrayList(), height, howManyStepsAtATime);
        return solutions.size();
    }

    private void search(Set<List<Integer>> solutions, int i, ArrayList<Integer> inProgress, int height,
                        int[] howManyStepsAtATime) {
        Integer sum = inProgress.stream().reduce(0, (a, b) -> a + b);
        if (sum > height) {
            return;
        }
        if (sum == height) {
            solutions.add(new ArrayList<>(inProgress));
            return;
        }
        for (int howManySteps : howManyStepsAtATime) {
            inProgress.add(howManySteps);
            search(solutions, i + 1, inProgress, height, howManyStepsAtATime);
            inProgress.remove(inProgress.size() - 1);
        }
    }
}
