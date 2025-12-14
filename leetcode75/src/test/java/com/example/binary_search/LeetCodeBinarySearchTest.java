package com.example.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void testFindPeakElement() {
		int[] firstTest = new int[] { 1, 2, 3, 1 };
		int[] secondTest = new int[] { 1, 2, 1, 3, 5, 6, 4 };
		int[] thirdTest = new int[] { 1, 2 };
		int[] fourthTest = new int[] { -2147483648 };
		int[] fifthTest = new int[] { -2147483647, -2147483648 };
		int[] sixTest = new int[] { 9, 7, 3, 7, 8 };

		assertEquals(0, leetCode.findPeakElement(sixTest));
		assertEquals(0, leetCode.findPeakElement(fifthTest));
		assertEquals(0, leetCode.findPeakElement(fourthTest));
		assertEquals(1, leetCode.findPeakElement(thirdTest));
		assertEquals(2, leetCode.findPeakElement(firstTest));
		assertTrue(leetCode.findPeakElement(secondTest) == 5 || leetCode.findPeakElement(
				secondTest) == 1);
	}
}