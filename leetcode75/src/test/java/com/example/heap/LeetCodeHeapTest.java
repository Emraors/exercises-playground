package com.example.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeHeapTest {

	private final LeetCodeHeap leetCode = new LeetCodeHeap();

	@Test
	void findKthLargest() {
		int[] firstTest = new int[] { 3, 2, 1, 5, 6, 4 };
		int[] secondTest = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };

		assertEquals(5, leetCode.findKthLargest(firstTest, 2));
		assertEquals(4, leetCode.findKthLargest(secondTest, 4));
	}
}