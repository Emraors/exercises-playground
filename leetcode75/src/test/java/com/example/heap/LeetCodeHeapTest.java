package com.example.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeHeapTest {

	private final LeetCodeHeap leetCode = new LeetCodeHeap();

	@Test
	void testFindKthLargest() {
		int[] firstTest = new int[] { 3, 2, 1, 1, 1, 1, 5, 6, 4 };
		int[] secondTest = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };

		assertEquals(5, leetCode.findKthLargest(firstTest, 2));
		assertEquals(4, leetCode.findKthLargest(secondTest, 4));
	}

	@Test
	void testMaxScore() {
		int[] firstTest1 = new int[] { 1, 3, 3, 2 };
		int[] firstTest2 = new int[] { 2, 1, 3, 4 };

		int[] secondTest1 = new int[] { 4, 2, 3, 1, 1 };
		int[] secondTest2 = new int[] { 7, 5, 10, 9, 6 };

		assertEquals(12L, leetCode.maxScore(firstTest1, firstTest2, 3));
		assertEquals(30L, leetCode.maxScore(secondTest1, secondTest2, 1));
	}

	@Test
	void testTotalCost() {
		int[] firstTest = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
		int[] secondTest = new int[]{1, 2, 4, 1};
		int[] thirdTest = new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};

		//assertEquals(11, leetCode.totalCost(firstTest, 3, 4));
		assertEquals(4, leetCode.totalCost(secondTest, 3, 3));
		assertEquals(423, leetCode.totalCost(thirdTest, 11, 2));
	}
}