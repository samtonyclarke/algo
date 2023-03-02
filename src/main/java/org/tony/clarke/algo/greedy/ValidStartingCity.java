package org.tony.clarke.algo.greedy;

public class ValidStartingCity {

    public static void main(String args[]) {
        ValidStartingCity validStartingCity = new ValidStartingCity();
        int i = validStartingCity.validStartingCity(new int[]{10, 10, 10, 10},
                new int[]{1, 2, 3, 4}, 4);
        System.out.println(i);
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // translate fuel to distance
        for (int i = 0; i < fuel.length; i++) {
            fuel[i] = fuel[i] * mpg;
        }
        // find which city would have the biggest cumulative deficit on entering...this must be the starting point
        int fuelSurplus = 0;
        int maxDeficit = Integer.MAX_VALUE;
        int validCityIndex = -1;
        for (int i = 0; i < distances.length; i++) {
            int cityIndex = i % distances.length;
            int priorCity = cityIndex - 1;
            if (priorCity < 0) {
                priorCity = distances.length - 1;
            }
            fuelSurplus += fuel[priorCity] - distances[priorCity];
            if (fuelSurplus < maxDeficit) {
                validCityIndex = i;
                maxDeficit = fuelSurplus;
            }
        }

        return validCityIndex;
    }
}
