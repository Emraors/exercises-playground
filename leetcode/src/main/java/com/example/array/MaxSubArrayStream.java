package com.example.array;

public class MaxSubArrayStream {
	private int mostRecentMax;
	private int maxEndingValue;

	public MaxSubArrayStream() {
		this.mostRecentMax = 0;
		this.maxEndingValue = 0;
	}

	public void accept(int x) {
		maxEndingValue = Math.max(maxEndingValue + x, x);
		mostRecentMax = Math.max(mostRecentMax, maxEndingValue);
	}

	public void accept(int[] chunk) {
		for (int c : chunk) {
			this.accept(c);
		}
	}

	public int getMostRecentMax() {
		return mostRecentMax;
	}

	public void reset() {
		this.mostRecentMax = 0;
		this.maxEndingValue = 0;
	}
}
