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
}