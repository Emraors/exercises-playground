package com.example.heap;

import java.util.Arrays;
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
        Integer res = priorityQueue.peek();
        return res != null ? res : Integer.MIN_VALUE;
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (a, b) -> Integer.compare(nums2[b], nums2[a]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0L;
        long best = 0L;

        for (int id : indexes) {
            int x1 = nums1[id];
            int x2 = nums2[id];
            minHeap.offer(x1);
            sum += x1;
            if (minHeap.size() > k) {
                Integer removed = minHeap.poll();
                if (removed != null) sum -= removed;
            }
            if (minHeap.size() == k) {
                best = Math.max(best, sum * (long) x2);
            }
        }
        return best;
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int nWorkers = costs.length;
        long totalCost = 0;
        var leftHeap = new PriorityQueue<Integer>();
        var rightHeap = new PriorityQueue<Integer>();

        int i = 0, j = nWorkers - 1;
        for (int c = 0; c < candidates && i <= j; c++) {
            leftHeap.offer(costs[i++]);
        }
        for (int c = 0; c < candidates && i <= j; c++) {
            rightHeap.offer(costs[j--]);
        }

        for (int round = 0; round < k; round++) {
            var leftMin = leftHeap.peek();
            var rightMin = rightHeap.peek();

            if (leftMin == null && rightMin == null) break;
            if (rightMin == null || (leftMin != null && leftMin <= rightMin)) {
                totalCost += leftHeap.poll();
                if (i <= j) {
                    leftHeap.offer(costs[i++]);
                }
            }
            else {
                totalCost += rightHeap.poll();
                if (i <= j) {
                    rightHeap.offer(costs[j--]);
                }
            }
        }
        return totalCost;
    }
}
