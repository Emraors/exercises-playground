package com.example.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {

	private final PriorityQueue<Integer> heap;
	private final Set<Integer> numbers;
	private int index;

	public SmallestInfiniteSet() {
		heap = new PriorityQueue<>();
		numbers = new HashSet<>();
		index = 1;
	}

	public int popSmallest() {
		if (!heap.isEmpty()) {
			int num = heap.poll();
			numbers.remove(num);
			return num;
		}
		return index++;
	}

	public void addBack(int num) {
		if (num < index && !numbers.contains(num)) {
			heap.offer(num);
			numbers.add(num);
		}
	}
}
