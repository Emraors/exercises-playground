package com.example.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeStackTest {

	private final LeetCodeStack leetCode = new LeetCodeStack();

	@Test
	public void testAsteroidCollision() {
		int[] firstTest = { 5, 10, -5 };
		int[] secondTest = { 8, -8 };
		int[] thirdTest = { 10, 2, -5 };
		int[] fourthTest = {};

		assertArrayEquals(new int[] { 5, 10 }, leetCode.asteroidCollision(firstTest));
		assertArrayEquals(new int[] {}, leetCode.asteroidCollision(secondTest));
		assertArrayEquals(new int[] { 10 }, leetCode.asteroidCollision(thirdTest));
		assertArrayEquals(new int[] {}, leetCode.asteroidCollision(fourthTest));
	}

	@Test
	public void testRemoveStars() {
		String s1 = "leet**cod*e";
		String s2 = "erase*****";

		assertEquals("lecoe", leetCode.removeStars(s1));
		assertEquals("", leetCode.removeStars(s2));
	}

	@Test
	public void testDecodeString() {
		String s = "3[a]2[bc]";
		String s1 = "2[abc]3[cd]ef";
		String s3 = "3[a2[c]]";
		String s4 = "abc";

		assertEquals("abc", leetCode.decodeString(s4));
		assertEquals("aaabcbc", leetCode.decodeString(s));
		assertEquals("abcabccdcdcdef", leetCode.decodeString(s1));
		assertEquals("accaccacc", leetCode.decodeString(s3));
	}
}