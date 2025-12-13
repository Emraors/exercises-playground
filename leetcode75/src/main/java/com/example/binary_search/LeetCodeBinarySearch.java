package com.example.binary_search;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class LeetCodeBinarySearch {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int nSpells = spells.length;
        int nPotions = potions.length;
        int[] pairs = new int[nSpells];

        BiPredicate<Integer, Integer> isSuccess = (s, p) -> (long) s * (long) p >= success;
        Arrays.sort(potions);

        return new int[]{};
    }
}
