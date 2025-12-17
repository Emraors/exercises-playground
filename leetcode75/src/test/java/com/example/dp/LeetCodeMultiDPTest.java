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
}