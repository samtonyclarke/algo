package org.tony.clarke.algo.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class BestDigits {

    public static void main(String args[]) {
        BestDigits bestDigits = new BestDigits();
        String s = bestDigits.bestDigits("11122", 3);
        System.out.println(s);
    }

    public String bestDigits(String number, int numDigits) {
        char[] chars = number.toCharArray();
        Stack<Character> digits = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            // if the next character is bigger than what we already have then removed what we have already up to numDigits times
            while (!digits.isEmpty() && chars[i] > digits.peek() && numDigits > 0) {
                numDigits--;
                digits.pop();
            }
            digits.push(chars[i]);
        }

        while (numDigits-- > 0) { // not removed enough digits yet
            digits.pop();
        }

        ArrayList<Character> result = new ArrayList<>(digits);
        StringBuilder sb = new StringBuilder();
        result.stream().forEach(i -> sb.append(i));
        return sb.toString();
    }
}
