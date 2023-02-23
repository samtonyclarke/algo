package org.tony.clarke.algo.recursion;

import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String args[]) {
        int productSum = productSum(Arrays.asList(5,2, Arrays.asList(7,-1), 3, Arrays.asList(6, Arrays.asList(-13,8), 4)));
        System.out.println(productSum);
    }
    public static int productSum(List<Object> array) {
        return productSumInternal(array, 2);
    }
    private static int productSumInternal (List<Object> array, int depth) {
        int sum = 0;
        for (Object object: array) {
            if(object instanceof List) {
                sum += depth * (productSumInternal((List<Object>) object, depth+1));
            } else {
                sum += (Integer)object;
            }
        }
        return sum;
    }

}
