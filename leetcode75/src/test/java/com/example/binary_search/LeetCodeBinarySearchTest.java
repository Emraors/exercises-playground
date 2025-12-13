package com.example.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeetCodeBinarySearchTest {

	private final LeetCodeBinarySearch leetCode = new LeetCodeBinarySearch();

	@Test
	void testSuccessfulPairs() {

		int[] emptySpells = new int[] {};
		int[] emptyPotions = new int[] {};

		int[] firstSpells = new int[] { 5, 1, 3 };
		int[] firstPotions = new int[] { 1, 2, 3, 4, 5 };

		int[] secondSpells = new int[] { 3, 1, 2 };
		int[] secondPotions = new int[] { 8, 5, 8 };

		assertArrayEquals(new int[] {}, leetCode.successfulPairs(emptySpells, emptyPotions, 1));
		assertArrayEquals(new int[] { 4, 0, 3 }, leetCode.successfulPairs(firstSpells, firstPotions, 7));
		assertArrayEquals(new int[] { 2, 0, 2 }, leetCode.successfulPairs(secondSpells, secondPotions, 16));
	}
}