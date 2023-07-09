package org.tony.clarke.algo.stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    private static final Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public static void main(String args[]) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int i = reversePolishNotation.reversePolishNotation(new String[]{"10"});
//        int i = reversePolishNotation.reversePolishNotation(new String[]{"50", "3", "17", "+", "2", "-", "/"});
        System.out.println(i);
    }

    public int reversePolishNotation(String[] tokens) {
        int toReturn;
        Stack<String> toProcess = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (!toProcess.isEmpty() && operators.contains(toProcess.peek())) {
                toProcess.push(Integer.toString(processOperation(toProcess.pop(), toProcess.pop(), toProcess.pop())));
            }
            toProcess.push(tokens[i]);
        }
        if(operators.contains(toProcess.peek())) {
            toReturn = processOperation(toProcess.pop(), toProcess.pop(), toProcess.pop());
        } else {
            toReturn = Integer.parseInt(toProcess.pop());
        }

        return toReturn;
    }

    private int processOperation(String operand, String right, String left) {
        switch (operand) {
            case "+":
                return Integer.parseInt(left) + Integer.parseInt(right);
            case "-":
                return Integer.parseInt(left) - Integer.parseInt(right);
            case "*":
                return Integer.parseInt(left) * Integer.parseInt(right);
            case "/":
                return Integer.parseInt(left) / Integer.parseInt(right);
        }

        return 0;
    }


}
