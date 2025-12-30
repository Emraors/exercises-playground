package com.example.binary_search;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class LeetCodeBinarySearch {

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		int nSpells = spells.length;

		if (nSpells == 0)
			return new int[] {};

		int nPotions = potions.length;
		int[] pairs = new int[nSpells];
		Arrays.sort(potions);

		BiPredicate<Integer, Integer> isSuccess = (s, p) -> (long) s * (long) p >= success;
		for (int i = 0; i < nSpells; i++) {
			int minIndexMatching = findMinIndexMatchingBinary(spells[i], potions, nPotions, isSuccess);
			pairs[i] = minIndexMatching == -1 ? 0 : nPotions - minIndexMatching;
		}

		return pairs;
	}

	private int findMinIndexMatchingBinary(int spellValue, int[] potions, int potionsLength,
			BiPredicate<Integer, Integer> isSuccess) {
		int left = 0;
		int right = potionsLength;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isSuccess.test(spellValue, potions[mid])) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if (left == potionsLength) {
			return -1;
		}
		return isSuccess.test(spellValue, potions[left]) ? left : -1;
	}

	private int findMinIndexMatching(int spellValue, int[] potions, int potionsLength,
			BiPredicate<Integer, Integer> isSuccess) {
		for (int i = 0; i < potionsLength; i++) {
			if (isSuccess.test(spellValue, potions[i])) {
				return i;
			}
		}
		return -1;
	}

	//Suggested by ChatGpt
	public int[] successfulPairsFaster(int[] spells, int[] potions, long success) {
		int nSpells = spells.length;
		if (nSpells == 0)
			return new int[] {};

		Arrays.sort(potions);
		int nPotions = potions.length;
		int[] pairs = new int[nSpells];

		for (int i = 0; i < nSpells; i++) {
			int spell = spells[i];
			if (spell <= 0) {
				pairs[i] = 0;
				continue;
			}
			long minPotion = (success + spell - 1L) / spell;
			int idx = lowerBound(potions, (int) Math.min(minPotion, Integer.MAX_VALUE));
			pairs[i] = idx < 0 ? 0 : (nPotions - idx);
		}
		return pairs;
	}

	private int lowerBound(int[] potions, int target) {
		int left = 0, right = potions.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (potions[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return (left == potions.length) ? -1 : left;
	}

	public int findPeakElement(int[] nums) {
		int length = nums.length;
		if (length == 0)
			return length;

		return binaryFind(nums, length);
	}

	private int binaryFind(int[] nums, int length) {
		int left = 0, right = length;
		while (left < right) {
			int mid = left + (right - left) / 2;

			switch (classifyNeighbors(nums, length, mid)) {
				case LEFT_BIGGER, LEFT_AND_RIGHT_BIGGER, NONE -> {
					right = mid;
				}
				case RIGHT_BIGGER -> {
					left = mid + 1;
				}
				case CENTER_BIGGER -> {
					return mid;
				}
			}
		}
		return left;
	}

	private int iterateFind(int[] nums, int length) {
		for (int i = 0; i < length; i++) {
			if (isPeak(nums, length, i))
				return i;
		}
		return -1;
	}

	private boolean isPeak(int[] nums, int numsLength, int index) {
		int left = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
		int right = index == numsLength - 1 ? Integer.MIN_VALUE : nums[index + 1];

		return nums[index] >= left && nums[index] >= right;
	}

	private NeighborTrend classifyNeighbors(int[] nums, int numsLength, int index) {
		int left = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
		int right = index == numsLength - 1 ? Integer.MIN_VALUE : nums[index + 1];
		int num = nums[index];

		if (left > num && right > num)
			return NeighborTrend.LEFT_AND_RIGHT_BIGGER;
		else if (left > num)
			return NeighborTrend.LEFT_BIGGER;
		else if (right > num)
			return NeighborTrend.RIGHT_BIGGER;
		else if (num > left && num > right)
			return NeighborTrend.CENTER_BIGGER;
		else
			return NeighborTrend.NONE;
	}

	private int binaryFind1(int[] nums, int length) {
		int left = 0, right = length;
		while (left < right) {
			int mid = left + (right - left) / 2, midValue = nums[mid], leftMid = mid == 0
					? Integer.MIN_VALUE
					: nums[mid - 1], rightMid = mid == length - 1 ? Integer.MIN_VALUE : nums[mid + 1];

			if (midValue < leftMid) {
				right = mid;
			} else if (midValue < rightMid) {
				left = mid + 1;
			}
			if (midValue >= leftMid && midValue >= rightMid) {
				return mid;
			}
		}
		return -1;
	}

	public int minEatingSpeed(int[] piles, int h) {
		if (piles.length == 0)
			return 0;
		int max = findMax(piles);

		return binaryMin(piles, max, h);
	}

	private int binaryMin(int[] piles, int max, int h) {
		int left = 1, right = max, mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (sumRatio(piles, mid) <= h) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private int sumRatio(int[] piles, int k) {
		int sum = 0;
		for (int pile : piles) {
			sum = sum + (pile + k - 1) / k;
		}
		return sum;
	}

	private int findMax(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int el : array) {
			if (el >= max)
				max = el;
		}
		return max;
	}

	private enum NeighborTrend {
		LEFT_BIGGER,
		RIGHT_BIGGER,
		CENTER_BIGGER,
		LEFT_AND_RIGHT_BIGGER,
		NONE
	}
}
