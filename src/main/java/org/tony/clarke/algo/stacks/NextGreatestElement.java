package org.tony.clarke.algo.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {

    public static void main(String args[]) {
        NextGreatestElement nextGreatestElement = new NextGreatestElement();
        int[] ints = nextGreatestElement.nextGreaterElement(new int[]{2, 5, -3, -4, 6, 7, 2});
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }


    public int[] nextGreaterElement(int[] array) {
        int toReturn[] = new int[array.length];
        Arrays.fill(toReturn, -1); // anything that is left behind means no greater value so prepopulate with -1
        // use stack to store up all elements that might be smaller than some future element...that way we do more with less work
        Stack<Integer> lookBackStackOfIndices = new Stack<>();

        for (int i = 0; i < array.length * 2; i++) {
            int wrapAroundIndex = i % array.length;
            while (!lookBackStackOfIndices.isEmpty() && // remove stack indices that are smaller than wrapAroundIndex
                    array[wrapAroundIndex] >
                            array[lookBackStackOfIndices.peek()]) { // look ahead for a bigger entry then drag back as much as possible
                int currentTopIndex = lookBackStackOfIndices.pop();
                toReturn[currentTopIndex] = array[wrapAroundIndex];
            }
            lookBackStackOfIndices.push(wrapAroundIndex);
        }
        return toReturn;
    }

}
