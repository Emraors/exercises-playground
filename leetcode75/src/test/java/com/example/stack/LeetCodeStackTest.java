package com.example.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeStackTest {

	private final LeetCodeStack leetCode = new LeetCodeStack();

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