package com.example.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeArrayTest {
	
	private final LeetCodeArray leetCode = new LeetCodeArray();

	@Test
	public void testKidsWithCandies() {
		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;

		int[] empty = {};

		List<Boolean> expected = List.of(true, true, true, false, true);

		assertEquals(expected, leetCode.kidsWithCandies(candies, extraCandies));
		assertEquals(List.of(), leetCode.kidsWithCandies(empty, 1));
	}

	@Test
	void testCanPlaceFlowers() {
		int[] flowersBed = { 1, 0, 0, 0, 1 };
		int n = 1;
		int m = 2;

		int[] one = { 0 };

		assertTrue(leetCode.canPlaceFlowers(flowersBed, n));
		assertFalse(leetCode.canPlaceFlowers(flowersBed, m));
		assertTrue(leetCode.isPlantable(one, 0));
	}

	@Test
	void testReverseVowels() {
		String s = "IceCreAm";
		String leetcode = "leetcode";
		String empty = "";

		String sol = leetCode.reverseVowels(s);
		String solEmpty = leetCode.reverseVowels(empty);
		String leetcodeSol = leetCode.reverseVowels(leetcode);

		assertEquals("AceCreIm", sol);
		assertEquals(empty, solEmpty);
		assertEquals("leotcede", leetcodeSol);

	}

	@Test
	void testReverseWords() {
		String s = "a good   example";
		String s1 = "  hello world  ";
		String s2 = "the sky is blue";

		assertEquals("example good a", leetCode.reverseWords(s));
		assertEquals("world hello", leetCode.reverseWords(s1));
		assertEquals("blue is sky the", leetCode.reverseWords(s2));
	}

	@Test
	public void testIncreasingTriplet() {
		int[] firstTest = { 1, 2, 3, 4, 5 };
		int[] secondTest = { 5, 4, 3, 2, 1 };
		int[] thirdTest = { 2, 1, 5, 0, 4, 6 };
		int[] fourthTest = { 2, 1, 5, 0, 4, 6 };
		int[] fifthTest = { -2, -1, 0 };
		int[] sixthTest = { 1, 1, 1, 1, 1 };
		int[] seventhTest = { 5, 1, 6 };
		int[] eightTest = { 2, 1, 5, 0, 3 };
		int[] ninthTest = { 1, 2, 1, 3 };

		assertFalse(leetCode.increasingTriplet(new int[] {}));
		assertFalse(leetCode.increasingTriplet(new int[] { 1, 2 }));
		assertTrue(leetCode.increasingTriplet(firstTest));
		assertFalse(leetCode.increasingTriplet(secondTest));
		assertTrue(leetCode.increasingTriplet(thirdTest));
		assertTrue(leetCode.increasingTriplet(fourthTest));
		assertTrue(leetCode.increasingTriplet(fifthTest));
		assertFalse(leetCode.increasingTriplet(sixthTest));
		assertFalse(leetCode.increasingTriplet(seventhTest));
		assertFalse(leetCode.increasingTriplet(eightTest));
		assertTrue(leetCode.increasingTriplet(ninthTest));
	}

	@Test
	public void testCompress() {
		char[] firstTest = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		char[] secondTest = { 'a', 'a', 'b' };
		char[] thirdTest = { 'a' };
		char[] fourthTest = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

		assertEquals(3, leetCode.compress(secondTest));
		assertEquals(6, leetCode.compress(firstTest));
		assertArrayEquals(new char[] { 'a', '2', 'b', '2', 'c', '3', 'c' }, firstTest);
		assertEquals(1, leetCode.compress(thirdTest));
		assertArrayEquals(new char[] { 'a' }, thirdTest);
		assertEquals(4, leetCode.compress(fourthTest));
	}

}