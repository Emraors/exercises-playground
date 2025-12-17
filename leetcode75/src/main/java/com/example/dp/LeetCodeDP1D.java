package com.example.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeDP1D {

	private final Map<Integer, Integer> memoizationTrib = new HashMap<>();
	private final Map<Set<Integer>, Integer> firstMemoizationRob = new HashMap<>();

	public void cleanState() {
		memoizationTrib.clear();
		firstMemoizationRob.clear();
	}

	public int tribonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;

		if (memoizationTrib.containsKey(n)) {
			return memoizationTrib.get(n);
		}

		int result = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
		memoizationTrib.put(n, result);
		return result;
	}

	public int minCostClimbingStairs(int[] cost) {
		int length = cost.length;

		if (length == 0)
			return 0;
		if (length == 1)
			return cost[0];

		int[] costPath = new int[length];

		costPath[length - 1] = cost[length - 1];
		costPath[length - 2] = cost[length - 2];

		for (int i = length - 3; i >= 0; i--) {
			costPath[i] = cost[i] + Math.min(costPath[i + 1], costPath[i + 2]);
		}

		return Math.min(costPath[0], costPath[1]);
	}

	public int rob(int[] nums) {
		int length = nums.length;

		if (length == 0)
			return 0;
		if (length == 1)
			return nums[0];

		int[] mem = new int[length];
		mem[0] = nums[0];
		mem[1] = Math.max(nums[1], nums[0]);

		for (int i = 2; i < length; i++) {
			mem[i] = Math.max(nums[i] + mem[i - 2], mem[i - 1]);
		}
		return mem[length - 1];
	}

	//This was my first solution, but it is inefficient
	public int robInefficient(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		Set<Integer> allowedIndexes = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			allowedIndexes.add(i);
			firstMemoizationRob.put(Set.of(i), nums[i]);
		}
		return robRecSupp(allowedIndexes, nums);
	}

	private int robRecSupp(Set<Integer> allowedIndexes, int[] nums) {
		if (allowedIndexes.isEmpty()) {
			return 0;
		}

		Integer cached = firstMemoizationRob.get(allowedIndexes);
		if (cached != null)
			return cached;

		int max = 0;
		for (Integer index : allowedIndexes) {
			Set<Integer> newAllowed = new HashSet<>(allowedIndexes);
			newAllowed.remove(index);
			newAllowed.remove(index - 1);
			newAllowed.remove(index + 1);

			int value = nums[index] + robRecSupp(newAllowed, nums);
			max = Math.max(max, value);
		}

		firstMemoizationRob.put(allowedIndexes, max);
		return max;
	}
}
