package com.example.prefix_sum;

public class LeetCodePrefixSum {
	public int largestAltitude(int[] gain) {
		int maxHeight = 0, currentHeight = 0;
		for (int n : gain) {
			currentHeight = currentHeight + n;
			maxHeight = Math.max(currentHeight, maxHeight);
		}
		return maxHeight;
	}

	public int pivotIndex(int[] nums) {
		int asc = 0, length = nums.length, desc = length - 1;
		int[] leftSums = new int[length];
		int[] rightSums = new int[length];

		while (asc < nums.length) {
			if (asc == 0)
				leftSums[asc] = 0;
			else
				leftSums[asc] = leftSums[asc - 1] + nums[asc - 1];
			if (desc == length - 1)
				rightSums[desc] = 0;
			else
				rightSums[desc] = rightSums[desc + 1] + nums[desc + 1];
			asc++;
			desc--;
		}
		int index = 0;
		while (index < length) {
			if (leftSums[index] == rightSums[index])
				return index;
			index++;
		}

		return -1;
	}
}
