package org.tony.clarke.algo.stacks;

import java.util.ArrayList;
import java.util.Arrays;

public class SortStack {

    public static void main(String args[]) {
        SortStack sortStack = new SortStack();
        sortStack.sortStack(new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1)));
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        Integer removed = stack.remove(stack.size() - 1);
        sortStack(stack);
        // never gets here until all items on stack are removed and all items removed are now available as 'removed' on the call stack
        sortStackInternal(stack, removed);
        return stack;
    }

    public void sortStackInternal(ArrayList<Integer> sortedStack, int previouslyRemoved) {
        if (sortedStack.isEmpty()) {
            sortedStack.add(previouslyRemoved);
            return;
        }
        if (sortedStack.get(sortedStack.size() - 1) <= previouslyRemoved) {
            sortedStack.add(previouslyRemoved); // add on the right position
            return;
        }
        // otherwise we cannot yet add...so we need to pop some off to find the right position, insert, then add back
        Integer topOfStack = sortedStack.remove(sortedStack.size() - 1);
        sortStackInternal(sortedStack, previouslyRemoved);
        sortedStack.add(topOfStack);
    }

}
