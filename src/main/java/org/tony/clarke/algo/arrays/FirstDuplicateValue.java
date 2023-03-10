package org.tony.clarke.algo.arrays;

public class FirstDuplicateValue {

    public static void main(String args[]) {
        FirstDuplicateValue firstDuplicateValue = new FirstDuplicateValue();
        int i = firstDuplicateValue.firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4});
        System.out.println(i);
    }

    public int firstDuplicateValue(int[] array) {
        // each position in the array can hold *two* bits of information.
        // 1. the number itself
        // 2. if the number is negative then it means that numbers index has been visited before

        // this works for numbers that index are ahead of us because we don't overwrite the value, we simply switch it
        // to a negative version of itself
        for (int i = 0; i < array.length; i++) {
            int mappedTo = -1;
            if (array[i] < 0) {
                mappedTo = Math.abs(array[i]) - 1;
            } else {
                mappedTo = array[i] - 1;
            }
            if (array[mappedTo] < 0) {
                return mappedTo + 1;
            } else {
                array[mappedTo] = array[mappedTo] * -1;
            }
        }
        return -1;
    }
}
