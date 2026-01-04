package com.example.two_pointers;

import java.util.Arrays;

public class LeetCodeTwoPointers {

	public void moveZeroes(int[] nums) {
		int write = 0;

		for (int scan = 0; scan < nums.length; scan++) {
			if (nums[scan] != 0) {
				nums[write] = nums[scan];
				write++;
			}
		}

		while (write < nums.length) {
			nums[write] = 0;
			write++;
		}
	}

	public boolean isSubsequence(String s, String t) {
		int sLength = s.length();
		int tLength = t.length();
		if (sLength > tLength)
			return false;
		if (sLength == 0)
			return true;

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		int sIndex = 0, tIndex = 0;
		while (tIndex < tLength && sIndex < sLength) {
			if (sArray[sIndex] == tArray[tIndex]) {
				sIndex++;
			}
			tIndex++;
		}
		return sIndex == sLength;
	}

	public int maxArea(int[] height) {
		int length = height.length, area = 0;
		if (length == 0)
			return 0;
		Pointer left = new Pointer(0, height);
		Pointer right = new Pointer(length - 1, height);
		while (left.index < right.index) {
			int i = evalWaterArea(left, right);
			if (i > area)
				area = i;
			if (left.isLessOrEqualThan(right))
				left.inc();
			else
				right.dec();
		}
		return area;
	}

	public int maxArea4ms(int[] height) {
		int length = height.length, area = 0;
		int left = 0, right = length - 1;
		while (left < right) {
			int leftValue = height[left];
			int rightValue = height[right];
			int actualArea = Math.min(rightValue, leftValue) * (right - left);
			if (actualArea > area)
				area = actualArea;
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return area;
	}

	private int evalWaterArea(Pointer left, Pointer right) {
		return Math.abs(right.index - left.index) * Math.min(left.value, right.value);
	}

	public int maxOperations(int[] nums, int k) {
		int length = nums.length, counter = 0;
		if (length == 0)
			return 0;
		Arrays.sort(nums);
		Pointer left = new Pointer(0, nums);
		Pointer right = new Pointer(length - 1, nums);
		while (left.index < right.index) {
			if (left.value + right.value == k) {
				counter++;
				left.inc();
				right.dec();
			} else if (left.value + right.value < k)
				left.inc();
			else
				right.dec();
		}
		return counter;
	}

	private static class Pointer implements Comparable<Pointer> {
		private final int[] ints;
		private int index;
		private int value;

		private Pointer(int index, int[] ints) {
			this.index = index;
			this.ints = ints;
			this.value = ints[index];
		}

		private void inc() {
			index++;
			value = ints[index];
		}

		private void dec() {
			index--;
			value = ints[index];
		}

		@Override
		public int compareTo(Pointer o) {
			return Integer.compare(value, o.value);
		}

		private boolean isLessOrEqualThan(Pointer o) {
			return this.compareTo(o) <= 0;
		}
	}
}
