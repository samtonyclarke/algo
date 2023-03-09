package org.tony.clarke.algo.arrays;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ArrayOfProductsRemembered {

    public static void main(String args[]) {
        ArrayOfProductsRemembered arrayOfProducts = new ArrayOfProductsRemembered();
        int[] ints = arrayOfProducts.arrayOfProducts(new int[]{5, 1, 4, 2});
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] arrayOfProducts(int[] array) {

        int[] left = new int[array.length];
        int runningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            left[i] = runningProduct;
            runningProduct = left[i] * array[i];
        }

        int[] right = new int[array.length];
        runningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            right[i] = runningProduct;
            runningProduct = right[i] * array[i];
        }

        int[] toReturn = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            toReturn[i] = left[i] * right[i];
        }

        return toReturn;
    }

}
