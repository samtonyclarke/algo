package org.tony.clarke.algo.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SunsetViews {

    public static void main(String args[]) {
        SunsetViews sunsetViews = new SunsetViews();
        ArrayList<Integer> integers = sunsetViews.sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST");
        integers.stream().forEach(i -> System.out.println(i));
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // more intuitive solution is not using a stack, but hmm they are looking for stack usage

        Stack<Integer> indicies = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        if (direction.equalsIgnoreCase("east")) {
            for (int i = 0; i < buildings.length; i++) {
                while (!indicies.isEmpty() && buildings[indicies.peek()] <= buildings[i]) {
                    indicies.pop(); // everything that remains on the stack must be taller than the current building
                }
                indicies.push(i);
            }
            result = new ArrayList<>(indicies);
        } else {
            for (int i = buildings.length-1; i >= 0; i--) {
                while (!indicies.isEmpty() && buildings[indicies.peek()] <= buildings[i]) {
                    indicies.pop(); // everything that remains on the stack must be taller than the current building
                }
                indicies.push(i);
            }
            result = new ArrayList<>(indicies);
            Collections.reverse(result);
        }

        return result;
    }
}
