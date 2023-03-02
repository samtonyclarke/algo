package org.tony.clarke.algo.greedy;

public class ValidStartingCityBruteForce {

    public static void main(String args[]) {
        ValidStartingCityBruteForce validStartingCity = new ValidStartingCityBruteForce();
        int i = validStartingCity.validStartingCity(new int[]{5, 25, 15, 10, 15}, new int[]{1, 2, 1, 0, 3}, 10);
        System.out.println(i);
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // translate fuel to distance
        for (int i = 0; i < fuel.length; i++) {
            fuel[i] = fuel[i] * mpg;
        }
        // try each starting city
        for (int j = 0; j < distances.length; j++) {
            int fuelSurplus = 0;
            int visited = 0;
            for (int i = j; i < distances.length + j; i++) {
                int cityIndex = i % distances.length;
                fuelSurplus += fuel[cityIndex] - distances[cityIndex];
                if (fuelSurplus < 0) {
                    break;
                }
                visited++;
            }
            if (visited == distances.length) {
                return j; // if we got here we complete a loop
            }
        }
        return -1;
    }
}
