package org.tony.clarke.algo.stacks;

public class MinMaxStack {

    public static void main(String args[]) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(2);
        minMaxStack.push(-1);
        minMaxStack.push(-10);
        minMaxStack.push(10);
        int max = minMaxStack.getMax();
        int min = minMaxStack.getMin();
        System.out.println("Current Max is: "+max);
        System.out.println("Current Min is: "+min);
        minMaxStack.pop();
        max = minMaxStack.getMax();
        min = minMaxStack.getMin();
        System.out.println("Current Max is: "+max);
        System.out.println("Current Min is: "+min);
        minMaxStack.pop();
        max = minMaxStack.getMax();
        min = minMaxStack.getMin();
        System.out.println("Current Max is: "+max);
        System.out.println("Current Min is: "+min);
    }

    private Node head;

    public int peek() {
        return this.head.val;
    }

    public int pop() {
        int toPop = this.head.val;
        this.head = this.head.prev;
        return toPop;
    }

    public void push(Integer number) {
        // at each push track what the current min/max is at that point
        int min = this.head == null ? number : Math.min(this.head.min, number);
        int max = this.head == null ? number : Math.max(this.head.max, number);
        this.head = new Node(number, min, max, this.head);
    }

    public int getMin() {
        return this.head.min;
    }

    public int getMax() {
        return this.head.max;
    }


    static class Node {
        int val;
        int min;

        int max;

        Node prev;

        public Node(int val, int min, int max, Node prev) {
            this.val = val;
            this.min = min;
            this.max = max;
            this.prev = prev;
        }
    }

}

