package com.example.sliding_window;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCodeSlidingWindow {
	public double findMaxAverage(int[] nums, int k) {
		int index = 0, length = nums.length, sum = 0;
		double average, maxAverage;
		while (index < k) {
			sum = sum + nums[index];
			index++;
		}
		average = (double) sum / k;
		maxAverage = average;
		while (index < length) {
			average = average + (double) (nums[index] - nums[index - k]) / k;
			maxAverage = Math.max(average, maxAverage);
			index++;
		}
		return maxAverage;
	}

	public int maxVowels(String s, int k) {
		char[] charArray = s.toCharArray();
		int index = 0, vowelNumber = 0, maxVowels;
		while (index < k) {
			if (isVowel(charArray[index]))
				vowelNumber++;
			index++;
		}
		maxVowels = vowelNumber;
		while (index < s.length()) {
			if (isVowel(charArray[index]))
				vowelNumber++;
			if (isVowel(charArray[index - k]))
				vowelNumber--;
			maxVowels = Math.max(vowelNumber, maxVowels);
			index++;
		}
		return maxVowels;
	}

	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public int longestOnes(int[] nums, int k) {
		int index = 0, length = nums.length, longest = 0, currentLength = 0, zeroCount = 0;
		if (length == 0)
			return 0;
		Queue<Integer> zerosIndex = new ArrayDeque<>(k);
		while (index < length) {
			if (nums[index] == 0) {
				if (zeroCount < k) {
					zerosIndex.add(index);
					zeroCount++;
					currentLength++;
					longest = Math.max(currentLength, longest);
				} else if (k > 0) {
					longest = Math.max(currentLength, longest);
					currentLength = index - zerosIndex.remove();
					zerosIndex.add(index);
				} else {
					longest = Math.max(currentLength, longest);
					currentLength = 0;
				}
			} else {
				currentLength++;
				longest = Math.max(currentLength, longest);
			}
			index++;
		}
		return longest;
	}

	public int longestSubarray(int[] nums) {
		int index = 0, length = nums.length, longest = 0, currentLength = 0, zeroCount = 0, zeroIndex =
				0;
		if (length == 0)
			return 0;
		while (index < length) {
			if (nums[index] == 0) {
				if (zeroCount < 1) {
					zeroIndex = index;
					zeroCount++;
					currentLength++;
					longest = Math.max(currentLength, longest);
				} else {
					longest = Math.max(currentLength, longest);
					currentLength = index - zeroIndex;
					zeroIndex = index;
				}
			} else {
				currentLength++;
				longest = Math.max(currentLength, longest);
			}
			index++;
		}
		return longest - 1;
	}
}
