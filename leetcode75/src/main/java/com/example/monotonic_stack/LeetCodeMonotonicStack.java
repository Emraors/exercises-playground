package com.example.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCodeMonotonicStack {

	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null) {
			return new int[] {};
		}
		int n = temperatures.length;
		int[] ans = new int[n];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int t = temperatures[i];
			while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
				int j = stack.pop();
				ans[j] = i - j;
			}
			stack.push(i);
		}
		return ans;
	}
}
