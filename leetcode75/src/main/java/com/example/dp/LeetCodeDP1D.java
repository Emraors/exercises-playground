package com.example.dp;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeDP1D {

	private final Map<Integer, Integer> memoizationTrib = new HashMap<>();

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
}
