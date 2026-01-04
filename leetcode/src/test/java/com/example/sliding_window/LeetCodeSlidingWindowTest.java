package com.example.sliding_window;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeSlidingWindowTest {

	private final LeetCodeSlidingWindow leetCode = new LeetCodeSlidingWindow();

	@Test
	void testFindMaxAverage() {
		int[] firstTest = { 1, 12, -5, -6, 50, 3 };
		int[] secondTest = { 12, -5, -6, 50 };

		assertEquals(12.75000, leetCode.findMaxAverage(firstTest, 4));
		assertEquals(12.75000, leetCode.findMaxAverage(secondTest, 4));
	}

	@Test
	void testMaxVowels() {
		String firstTest = "abciiidef";
		String secondTest = "aeiou";
		String thirdTest = "leetcode";

		assertEquals(3, leetCode.maxVowels(firstTest, 3));
		assertEquals(2, leetCode.maxVowels(secondTest, 2));
		assertEquals(2, leetCode.maxVowels(thirdTest, 3));
	}

	@Test
	void testLongestOnes() throws IOException {
		int[] firstTest = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 };
		int[] secondTest = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int[] thirdTest = { 0, 0, 1, 1, 1, 0, 0 };
		int[] fourthTest = { 0, 0, 0, 1 };
/*		int[] fifthTest = loadTestArrayFromFile(
				"C:\\Users\\gbs10217\\Workspace\\Examples\\DownOptionPOC\\src\\test\\resources\\long_array.txt");*/

		assertEquals(6, leetCode.longestOnes(firstTest, 2));
		assertEquals(10, leetCode.longestOnes(secondTest, 3));
		assertEquals(3, leetCode.longestOnes(thirdTest, 0));
		assertEquals(4, leetCode.longestOnes(fourthTest, 4));
		//assertEquals(12500, leetCode.longestOnes(fifthTest, 6250));

	}

	@Test
	void testLongestSubarray() {

		int[] firstTest = { 1, 1, 0, 1 };
		int[] secondTest = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		int[] thirdTest = { 1, 1, 1 };

		assertEquals(3, leetCode.longestSubarray(firstTest));
		assertEquals(5, leetCode.longestSubarray(secondTest));
		assertEquals(2, leetCode.longestSubarray(thirdTest));
	}

	int[] loadTestArrayFromFile(String filename) throws IOException {
		String contenuto = Files.readString(Paths.get(filename));

		return Arrays.stream(contenuto.trim().split("\\s*,\\s*")).filter(s -> !s.isEmpty())
				.mapToInt(Integer::parseInt).toArray();
	}
}