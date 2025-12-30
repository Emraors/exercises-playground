package com.example.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeetCodeArrayTest {

	@Test
	void productExceptSelfExample() {
		LeetCodeArray arr = new LeetCodeArray();
		int[] input = { 1, 2, 3, 4 };
		int[] expected = { 24, 12, 8, 6 };
		assertArrayEquals(expected, arr.productExceptSelf(input));
	}

	@Test
	void productExceptSelfWithZero() {
		LeetCodeArray arr = new LeetCodeArray();
		int[] input = { 0, 1, 2, 3 };
		int[] expected = { 6, 0, 0, 0 };
		assertArrayEquals(expected, arr.productExceptSelf(input));

		input = new int[] { 0, 0, 2, 3 };
		expected = new int[] { 0, 0, 0, 0 };
		assertArrayEquals(expected, arr.productExceptSelf(input));
	}

	@Test
	void productExceptSelfSingleAndEmpty() {
		LeetCodeArray arr = new LeetCodeArray();
		assertArrayEquals(new int[] {}, arr.productExceptSelf(new int[] {}));
		assertArrayEquals(new int[] { 1 }, arr.productExceptSelf(new int[] { 5 }));
	}
}
