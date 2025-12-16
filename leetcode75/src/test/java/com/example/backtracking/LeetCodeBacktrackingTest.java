package com.example.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeBacktrackingTest {

	private final LeetCodeBacktracking leetCode = new LeetCodeBacktracking();

	@Test
	void testLetterCombinationsFirstSolution() {
		String firstTest = "23";
		String secondTest = "2";

		assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
				leetCode.letterCombinations(firstTest));
		assertEquals(List.of("a", "b", "c"),
				leetCode.letterCombinations(secondTest));
	}

	@Test
	void testCombinationSum3() {

		assertEquals(List.of(List.of(1, 2, 4)), leetCode.combinationSum3(3, 7));
		assertEquals(List.of(List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 3, 4)), leetCode.combinationSum3(3, 9));
		assertEquals(List.of(), leetCode.combinationSum3(4, 1));
	}
}