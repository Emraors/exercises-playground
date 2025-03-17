package com.example.prefix_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodePrefixSumTest {

	private final LeetCodePrefixSum leetCode = new LeetCodePrefixSum();

	@Test
	void testLargestAltitude() {
		int[] firstTest = { -5, 1, 5, 0, -7 };
		int[] secondTest = { -4, -3, -2, -1, 4, 3, 2 };

		assertEquals(1, leetCode.largestAltitude(firstTest));
		assertEquals(0, leetCode.largestAltitude(secondTest));
	}

	@Test
	void testPivotIndex() {
		int[] firstTest = { 1, 7, 3, 6, 5, 6 };
		int[] secondTest = { 1, 2, 3 };

		assertEquals(3, leetCode.pivotIndex(firstTest));
		assertEquals(-1, leetCode.pivotIndex(secondTest));
	}
}