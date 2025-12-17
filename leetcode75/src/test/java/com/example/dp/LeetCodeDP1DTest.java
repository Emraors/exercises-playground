package com.example.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeDP1DTest {

	private final LeetCodeDP1D leetCode = new LeetCodeDP1D();

	@Test
	void testTribonacci() {

		assertEquals(4, leetCode.tribonacci(4));
		assertEquals(1389537, leetCode.tribonacci(25));
	}

	@Test
	void testMinCostClimbingStairs() {

		int[] firstTest = new int[] { 10, 15, 20 };
		int[] secondTest = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

		assertEquals(15, leetCode.minCostClimbingStairs(firstTest));
		assertEquals(6, leetCode.minCostClimbingStairs(secondTest));
	}

	@Test
	void testRob() {

		int[] firstTest = new int[] { 1, 2, 3, 1 };
		int[] secondTest = new int[] { 2, 7, 9, 3, 1 };
		int[] thirdTest = new int[] { 2, 1, 1, 2 };
		int[] fourthTest = new int[] { 100, 10, 1, 10, 100 };
		int[] fifthTest = new int[] { 183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90,
				238, 168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211 };

		assertEquals(4, leetCode.rob(firstTest));
		leetCode.cleanState();
		assertEquals(12, leetCode.rob(secondTest));
		leetCode.cleanState();
		assertEquals(4, leetCode.rob(thirdTest));
		leetCode.cleanState();
		assertEquals(201, leetCode.rob(fourthTest));
		leetCode.cleanState();
		assertEquals(3365, leetCode.rob(fifthTest));
	}
}