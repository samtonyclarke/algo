package org.tony.clarke.algo.recursion;

import java.util.HashMap;
import java.util.Map;

public class StairCaseTraversalBetter {

    Map<Integer, Integer> stepWaysMemoization = new HashMap<>();

    public static void main(String args[]) {
        StairCaseTraversalBetter stairCaseTraversal = new StairCaseTraversalBetter();
        int i = stairCaseTraversal.staircaseTraversal(4, 3);
        System.out.println(i);
    }

    public int staircaseTraversal(int height, int maxSteps) {
        if (height<0) {
            return 0;
        }
        if (height == 0 || height == 1) {
            return 1;
        } else {
            if (stepWaysMemoization.containsKey(height)) {
                return stepWaysMemoization.get(height);
            }
            int sum = 0;
            for (int i = 1; i <= maxSteps; i++) {
                sum += staircaseTraversal(height-i, maxSteps);
            }
            stepWaysMemoization.put(height, sum);
            return sum;
        }
    }


}
