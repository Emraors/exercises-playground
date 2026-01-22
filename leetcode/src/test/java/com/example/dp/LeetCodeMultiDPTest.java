package com.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeMultiDPTest {

	private final LeetCodeMultiDP leetCode = new LeetCodeMultiDP();

	@Test
	void testUniquePaths() {
		assertEquals(28, leetCode.uniquePaths(3, 7));
		assertEquals(3, leetCode.uniquePaths(3, 2));
	}

	@Test
	void testLongestCommonSubsequence() {
		assertEquals(3, leetCode.longestCommonSubsequence("abcde", "ace"));
		assertEquals(3, leetCode.longestCommonSubsequence("abc", "abc"));
		assertEquals(0, leetCode.longestCommonSubsequence("abc", "def"));
	}

	@Test
	void testMaxProfitWithFee() {
		int[] firstTest = new int[] { 1, 3, 2, 8, 4, 9 };
		int[] secondTest = new int[] { 1, 3, 7, 5, 10, 3 };
		int[] thirdTest = new int[] { 7, 6, 4, 3, 1 };

		assertEquals(8, leetCode.maxProfit(firstTest, 2));
		assertEquals(6, leetCode.maxProfit(secondTest, 3));
		assertEquals(0, leetCode.maxProfit(thirdTest, 0));
	}

	@Test
	void testMinDistance() {
		assertEquals(3, leetCode.minDistance("horse", "ros"));
		assertEquals(5, leetCode.minDistance("intention", "execution"));
	}

	@Test
	void testMaxProfit() {
		int[] firstTest = new int[] { 7, 1, 5, 3, 6, 4 };
		int[] secondTest = new int[] { 7, 6, 4, 3, 1 };

		assertEquals(5, leetCode.maxProfit(firstTest));
		assertEquals(0, leetCode.maxProfit(secondTest));
	}
}