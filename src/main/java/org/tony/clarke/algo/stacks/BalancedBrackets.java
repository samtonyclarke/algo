package org.tony.clarke.algo.stacks;

import java.util.*;

public class BalancedBrackets {


    public static void main(String args[]) {
        boolean b = balancedBrackets("(a)");
        System.out.println(b);
    }

    public static boolean balancedBrackets(String str) {
        ArrayList openBracket = new ArrayList(Arrays.asList('(', '{', '['));
        ArrayList closedBracket = new ArrayList(Arrays.asList(')', '}', ']'));
        Map<Character, Character> reverse = new HashMap<>();
        reverse.put(')', '(');
        reverse.put(']', '[');
        reverse.put('}', '{');
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (openBracket.contains(chars[i])) {
                stack.push(chars[i]);
            } else if (closedBracket.contains(chars[i])) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop.charValue() != reverse.get(chars[i])) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
