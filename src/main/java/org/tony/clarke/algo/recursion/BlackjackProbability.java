package org.tony.clarke.algo.recursion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


public class BlackjackProbability {

    Map<Integer, Float> blackJackMemoization = new HashMap<>();

    public static void main(String args[]) {
        BlackjackProbability blackjackProbability = new BlackjackProbability();
        float v = blackjackProbability.blackjackProbability(21, 13);
        System.out.println(v);

    }

    public float blackjackProbability(int target, int startingHand) {
        if (blackJackMemoization.containsKey(startingHand)) {
            return blackJackMemoization.get(startingHand);
        }
        if (startingHand > target) {
            return 1.0f; // already bust
        }

        if (startingHand + 4 >= target) {
            return 0f; // not playing another card
        }

        float probability = 0.0f;
        for (int i = 1; i < 11; i++) {
            probability += 0.1f * blackjackProbability(target, startingHand + i);
        }
        blackJackMemoization.put(startingHand, probability);
        return probability;
    }
}
