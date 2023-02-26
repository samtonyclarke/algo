package org.tony.clarke.algo.famous;

public class Kadane {

    public static void main(String args[]) {
//        int maxSum = kadanesAlgorithmV2(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4});
        int maxSum = kadanesAlgorithmV2(new int[]{-10, -2, -9, -4, -8, -6, -7, -1, -3, -5});
//        int maxSum = kadanesAlgorithm(new int[]{-2, -1});
//        int maxSum = kadanesAlgorithmV2(new int[]{-10});
        System.out.println(maxSum);
    }

    public static int kadanesAlgorithm(int[] array) {
        Integer maxSoFar = array[0];
        Integer maxNumber = array[0];
        Integer sumSoFar = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
            if (array[i] > -1 || (sumSoFar != null && sumSoFar > Math.abs(array[i]))) {
                if (sumSoFar == null) {
                    sumSoFar = 0;
                }
                sumSoFar += array[i];
                if (sumSoFar > maxSoFar) {
                    maxSoFar = sumSoFar;
                }
            } else if (array[i] < 0) {
                if (sumSoFar != null && sumSoFar > maxSoFar) {
                    maxSoFar = sumSoFar;
                }
                sumSoFar = null;
            }
        }

        return Integer.max(maxSoFar, maxNumber);
    }

    public static int kadanesAlgorithmV2(int[] array) {
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.max(array[i], array[i] + array[i - 1]);
            if(array[i] > maxSoFar) {
                maxSoFar = array[i];
            }
        }
        return maxSoFar;
    }
}

