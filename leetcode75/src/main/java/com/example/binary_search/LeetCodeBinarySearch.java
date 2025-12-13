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
}
