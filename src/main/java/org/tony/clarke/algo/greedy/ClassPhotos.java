package org.tony.clarke.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {

    public static void main(String[] args) {
        boolean canTakePhoto = new ClassPhotos().classPhotos(new ArrayList<>(List.of(6, 9, 2, 4, 5, 1)),
                new ArrayList<>(List.of(5, 8, 1, 3, 4, 9)));
        System.out.println(canTakePhoto);
    }

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        if(redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            return allGreaterThan(redShirtHeights, blueShirtHeights);
        } else {
            return allGreaterThan(blueShirtHeights, redShirtHeights);
        }

    }

    private boolean allGreaterThan(ArrayList<Integer> shouldBeBigger, ArrayList<Integer> shouldBeSmaller) {
        boolean allGreater = true;
        for (int i = 0; i < shouldBeBigger.size(); i++) {
            if (shouldBeSmaller.get(i) >= shouldBeBigger.get(i)) {
                return false;
            }
        }
        return allGreater;
    }

}
