package com.example.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeetCodeBinarySearchTest {

    private final LeetCodeBinarySearch leetCode = new LeetCodeBinarySearch();

    @Test
    void testSuccessfulPairs() {
        int[] firstSpell = new int[]{5, 1, 3};
        int[] firstPotions = new int[]{4, 0, 3};

        int[] secondSpell = new int[]{3, 1, 2};
        int[] secondPotions = new int[]{8, 5, 8};

        assertArrayEquals(new int[]{4, 0, 3}, leetCode.successfulPairs(firstSpell, firstPotions, 7));
        assertArrayEquals(new int[]{2, 0, 2}, leetCode.successfulPairs(secondSpell, secondPotions, 16));
    }
}