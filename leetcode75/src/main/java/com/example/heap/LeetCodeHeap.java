package com.example.heap;

import java.util.PriorityQueue;

public class LeetCodeHeap {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int num : nums) {
			priorityQueue.offer(num);
			if (priorityQueue.size() > k) {
				priorityQueue.poll();
			}
		}
		return priorityQueue.poll();
	}

	public long maxScore(int[] nums1, int[] nums2, int k) {
		return 0L;
	}

}
