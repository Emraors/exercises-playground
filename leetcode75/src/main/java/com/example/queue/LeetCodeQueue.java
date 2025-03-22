package com.example.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCodeQueue {

	public RecentCounter getInstance() {
		return new RecentCounter();
	}

	public static class RecentCounter {
		private final int bufferSize = 3000;
		private final Queue<Integer> call;

		public RecentCounter() {
			call = new ArrayDeque<>();
		}

		public int ping(int t) {
			call.offer(t);
			while (!call.isEmpty() && call.peek() < t - bufferSize) {
				call.poll();
			}
			return call.size();
		}
	}
}
