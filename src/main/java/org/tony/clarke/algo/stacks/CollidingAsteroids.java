package org.tony.clarke.algo.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CollidingAsteroids {


    public static void main(String args[]) {
        CollidingAsteroids collidingAsteroids = new CollidingAsteroids();
//        int[] ints = collidingAsteroids.collidingAsteroids(new int[]{1, 2, 3, -4});
//        int[] ints = collidingAsteroids.collidingAsteroids(new int[]{-3, 5, -8, 6, 7, -4, -7});
        int[] ints = collidingAsteroids.collidingAsteroids(new int[]{4, 7, -3, -5, 6, -10, 100, -50, 99});
        Arrays.stream(ints).forEach(System.out::println);
    }

    public int[] collidingAsteroids(int[] asteroids) {
        Stack<Integer> toProcess = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (toProcess.isEmpty()) {
                toProcess.push(asteroids[i]);
            } else {

                Integer next = asteroids[i];
                boolean addNext = true;
                while (!toProcess.isEmpty() && toProcess.peek() > 0 && next < 0) { // collision occurs
                    // need to decide who wins the collision
                    if (Math.abs(toProcess.peek()) > Math.abs(next)) {
                        // do nothing currentTop stays
                        addNext = false;
                        break;
                    } else if (Math.abs(toProcess.peek()) < Math.abs(next)) {
                        // replace currentTop
                        toProcess.pop();
                    } else { // equal
                        toProcess.pop();
                        addNext = false;
                        break;
                    }
                }
                if (addNext) {
                    toProcess.push(next);
                }
            }
        }

        int[] toReturn = new int[toProcess.size()];
        final int[] a = {0};
        toProcess.stream().

                forEach(i ->

                {
                    toReturn[a[0]] = i;
                    a[0]++;
                });

        return toReturn;
    }

}
