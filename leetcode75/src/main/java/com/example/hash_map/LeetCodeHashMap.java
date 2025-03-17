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
			Integer i = frequencies.get(c);
			if (Objects.isNull(i)) {
				frequencies.put(c, 1);
			} else {
				frequencies.put(c, i + 1);
			}
		}
		return frequencies;
	}

	public int equalPairs(int[][] grid) {
		int counter = 0, length = grid.length;
		int[] ints = new int[length];
		HashMap<Integer, int[]> rows = new HashMap<>();
		HashMap<Integer, int[]> columns = new HashMap<>();
		for (int[] row : grid) {
			rows.put(counter, row);
			columns.put(counter, new int[length]);
			counter++;
		}
		return 0;
	}

}
