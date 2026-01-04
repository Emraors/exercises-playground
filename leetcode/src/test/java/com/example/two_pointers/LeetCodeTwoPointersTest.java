package com.example.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeTwoPointersTest {

	private final LeetCodeTwoPointers leetCode = new LeetCodeTwoPointers();
	private final StateMachineExperiment experiment = new StateMachineExperiment();

	@Test
	public void testMoveZeroes() {
		int[] firstTest = { 0, 1, 0, 3, 12 };
		int[] secondTest = { 0 };
		int[] thirdTest = { 1, 0, 0, 2, 0 };
		int[] fourthTest = { 1, 0, 2 };

		leetCode.moveZeroes(firstTest);
		leetCode.moveZeroes(secondTest);
		leetCode.moveZeroes(thirdTest);
		leetCode.moveZeroes(fourthTest);

		// moveZeroes just mutates the given input
		assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, firstTest);
		assertArrayEquals(new int[] { 0 }, secondTest);
		assertArrayEquals(new int[] { 1, 2, 0, 0, 0 }, thirdTest);
		assertArrayEquals(new int[] { 1, 2, 0 }, fourthTest);
	}

	@Test
	public void testIsSubsequence() {
		String s = "abc";
		String t = "ahbgdc";

		String s1 = "axc";
		String t1 = "ahbgdc";

		String s2 = "";
		String t2 = "ahbgdc";

		String s3 = "b";
		String t3 = "abc";

		assertTrue(leetCode.isSubsequence(s, t));
		assertFalse(leetCode.isSubsequence(s1, t1));
		assertTrue(leetCode.isSubsequence(s2, t2));
		assertTrue(leetCode.isSubsequence(s3, t3));
	}

	@Test
	void testMaxArea() {
		int[] firstTest = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		assertEquals(49, leetCode.maxArea(firstTest));
	}

	@Test
	void testMaxOperations() {
		int[] firstTest = { 1, 2, 3, 4 };
		int[] secondTest = { 3, 1, 3, 4, 3 };

		assertEquals(2, leetCode.maxOperations(firstTest, 5));
		assertEquals(0, leetCode.maxOperations(firstTest, 0));
		assertEquals(0, leetCode.maxOperations(new int[] {}, 2));
		assertEquals(1, leetCode.maxOperations(secondTest, 6));
	}

	@Test
	public void testIsPalindrome() {

		assertTrue(experiment.isPalindrome(""));
		assertTrue(experiment.isPalindrome("a"));
		assertTrue(experiment.isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(experiment.isPalindrome("race a car"));
		assertTrue(experiment.isPalindrome("., "));
		assertFalse(experiment.isPalindrome("0P"));
	}
}