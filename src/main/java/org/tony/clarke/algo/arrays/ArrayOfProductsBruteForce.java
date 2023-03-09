package org.tony.clarke.algo.arrays;

public class ArrayOfProductsBruteForce {

    public static void main(String args[]) {
        ArrayOfProductsBruteForce arrayOfProducts = new ArrayOfProductsBruteForce();
        int[] ints = arrayOfProducts.arrayOfProducts(new int[]{5, 1, 4, 2});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] arrayOfProducts(int[] array) {
        int[] toReturn = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int left = left(array, i - 1);
            int right = right(array, i + 1);
            toReturn[i] = left * right;
        }
        return toReturn;
    }

    private int left(int[] array, int pivot) {
        int toReturn = 1;
        for (int i = 0; i <= pivot; i++) {
            toReturn *= array[i];
        }
        return toReturn;
    }

    private int right(int[] array, int pivot) {
        int toReturn = 1;
        for (int i = pivot; i < array.length; i++) {
            toReturn *= array[i];
        }
        return toReturn;
    }

}
