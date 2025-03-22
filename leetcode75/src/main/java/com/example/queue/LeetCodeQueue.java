package com.example.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCodeQueue {

	public RecentCounter getInstance() {
		return new RecentCounter();
	}

	public String predictPartyVictory(String senate) {
		char[] charArray = senate.toCharArray();
		int length = charArray.length, currentIndex = 0;
		Queue<Integer> radiant = new ArrayDeque<>();
		Queue<Integer> dire = new ArrayDeque<>();

		for (int i = 0; i < length; i++) {
			if (charArray[i] == 'R')
				radiant.offer(i);
			else
				dire.offer(i);
		}

		while (!radiant.isEmpty() && !dire.isEmpty()) {
			if (radiant.peek() == currentIndex) {
				dire.poll();
				radiant.offer(radiant.poll());
			}
			if (!dire.isEmpty() && dire.peek() == currentIndex) {
				radiant.poll();
				dire.offer(dire.poll());
			}
			currentIndex = (currentIndex + 1) % length;
		}

		return radiant.isEmpty() ? "Dire" : "Radiant";
	}
/*	public String predictPartyVictory(String senate) {
		char[] charArray = senate.toCharArray();
		int length = charArray.length, currentIndex = 0, direCount = 0, radiantCount = 0;
		List<Character> buffer = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			buffer.add(charArray[i]);
			if (charArray[i] == 'R')
				radiantCount++;
			else
				direCount++;
		}

		while ((radiantCount != 0) && (direCount != 0)) {
			Character c = buffer.get(currentIndex);
			if (c != buffer.get((currentIndex + 1) % length)) {
				buffer.remove((currentIndex + 1) % length);
				if (c == 'R')
					direCount--;
				else
					radiantCount--;
				length = length - 1;
			}
			currentIndex = (currentIndex + 1) % length;
		}

		return radiantCount == 0 ? "Dire" : "Radiant";
	}*/

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
