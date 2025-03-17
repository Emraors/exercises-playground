package com.example.hash_map;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeHashMapTest {

	private final LeetCodeHashMap leetCode = new LeetCodeHashMap();

	@Test
	void testFindDistinctDifference() {
		int[] firstTest1 = { 1, 2, 3 };
		int[] firstTest2 = { 2, 4, 6 };

		assertEquals(List.of(List.of(1, 3), List.of(4, 6)),
				leetCode.findDifference(firstTest1, firstTest2));
	}

	@Test
	void testUniqueOccurrences() {
		int[] firstTest = { 1, 2, 2, 1, 1, 3 };
		int[] secondTest = { 1, 2 };
		int[] thirdTest = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };

		assertTrue(leetCode.uniqueOccurrences(firstTest));
		assertFalse(leetCode.uniqueOccurrences(secondTest));
		assertTrue(leetCode.uniqueOccurrences(thirdTest));
	}

	@Test
	void testCloseString() {
		String word1FirstTest = "abc", word2FirstTest = "bca";
		String word1SecondTest = "a", word2SecondTest = "aa";
		String word1ThirdTest = "cabbba", word2ThirdTest = "abbccc";
		String word1FourthTest = "aaabbbbccddeeeeefffff", word2FourthTest = "aaaaabbcccdddeeeeffff";

		assertTrue(leetCode.closeStrings(word1FirstTest, word2FirstTest));
		assertFalse(leetCode.closeStrings(word1SecondTest, word2SecondTest));
		assertTrue(leetCode.closeStrings(word1ThirdTest, word2ThirdTest));
		assertFalse(leetCode.closeStrings(word1FourthTest, word2FourthTest));
	}

	@Test
	void testEqualPairs() {
		int[][] firstTest = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
		int[][] secondTest = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };

		assertEquals(1, leetCode.equalPairs(firstTest));
		assertEquals(3, leetCode.equalPairs(secondTest));
	}

	@Test
	public void testDecodeString() {
		String s = "3[a]2[bc]";
		String s1 = "2[abc]3[cd]ef";
		String s3 = "3[a2[c]]";
		String s4 = "abc";

		String a = leetCode.decodeString(s3);
		assertEquals("abc", leetCode.decodeString(s4));
		assertEquals("aaabcbc", leetCode.decodeString(s));
		assertEquals("abcabccdcdcdef", leetCode.decodeString(s1));
		assertEquals("accaccacc", leetCode.decodeString(s3));
	}
}