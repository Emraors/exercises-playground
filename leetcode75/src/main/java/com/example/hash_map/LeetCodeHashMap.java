package com.example.hash_map;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeHashMap {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> distinctNums1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		Set<Integer> distinctNums2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

		for (int num : nums1) {
			if (distinctNums2.contains(num)) {
				distinctNums1.remove(num);
				distinctNums2.remove(num);
			}
		}
		return List.of(distinctNums1.stream().toList(), distinctNums2.stream().toList());
	}

	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> valueOccurrenceMap = new HashMap<>();
		Set<Integer> occurences = new HashSet<>();
		int distinctElement = 0;
		for (int num : arr) {
			Integer i = valueOccurrenceMap.get(num);
			if (Objects.isNull(i)) {
				valueOccurrenceMap.put(num, 1);
				distinctElement++;
			} else {
				valueOccurrenceMap.put(num, i + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : valueOccurrenceMap.entrySet()) {
			occurences.add(entry.getValue());
		}

		return occurences.size() == distinctElement;
	}

	public boolean closeStrings(String word1, String word2) {
		HashMap<Character, Integer> frequencies1 = getFrequencies(word1);
		HashMap<Character, Integer> frequencies2 = getFrequencies(word2);

		return frequencies1.keySet().equals(frequencies2.keySet()) && frequencies1.values().stream()
				.sorted().toList().equals(frequencies2.values().stream().sorted().toList());
	}

	private HashMap<Character, Integer> getFrequencies(String word) {
		HashMap<Character, Integer> frequencies = new HashMap<>();
		for (char c : word.toCharArray()) {
			frequencies.put(c, frequencies.getOrDefault(c, 1) + 1);
		}
		return frequencies;
	}

	public int equalPairs(int[][] grid) {
		int n = grid.length, count = 0;
		Map<ArrayKey, Integer> frequency = new HashMap<>();
		for (int[] row : grid) {
			ArrayKey key = new ArrayKey(row);
			frequency.put(key, frequency.getOrDefault(key, 0) + 1);
		}
		for (int j = 0; j < n; j++) {
			int[] col = new int[n];
			for (int i = 0; i < n; i++) {
				col[i] = grid[i][j];
			}
			ArrayKey key = new ArrayKey(col);
			count += frequency.getOrDefault(key, 0);
		}
		return count;
	}

	private static class ArrayKey {
		private final int[] array;

		public ArrayKey(int[] array) {
			this.array = array;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof ArrayKey other))
				return false;
			return Arrays.equals(this.array, other.array);
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(array);
		}
	}

}
