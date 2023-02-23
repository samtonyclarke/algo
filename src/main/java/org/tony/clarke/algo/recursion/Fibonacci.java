package org.tony.clarke.algo.recursion;

public class Fibonacci {

    public static void main(String args[]) {
        int nthFib = getNthFib(6);
        System.out.println(nthFib);
    }

    public static int getNthFib(int n) {
        return getNthFibReal(n-1);
    }

    public static int getNthFibReal(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return getNthFibReal(n-1) + getNthFibReal(n-2);
    }

}
