package com.example.bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeBitManipulationTest {

	private final LeetCodeBitManipulation leetCode = new LeetCodeBitManipulation();

	@Test
	void testCountBits() {
		assertArrayEquals(new int[] { 0, 1, 1 }, leetCode.countBits(2));
		assertArrayEquals(new int[] { 0, 1, 1, 2, 1, 2 }, leetCode.countBits(5));
	}

	@Test
	void testSingleNumber() {
		int[] firstTest = new int[] { 2, 2, 1 };
		int[] secondTest = new int[] { 4, 1, 2, 1, 2 };
		int[] thirdTest = new int[] { 1 };

		assertEquals(1, leetCode.singleNumber(firstTest));
		assertEquals(4, leetCode.singleNumber(secondTest));
		assertEquals(1, leetCode.singleNumber(thirdTest));
	}

	@Test
	void testMinFlips() {
		assertEquals(3, leetCode.minFlips(2, 6, 5));
		assertEquals(1, leetCode.minFlips(4, 2, 7));
		assertEquals(0, leetCode.minFlips(1, 2, 3));
	}
}