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
}