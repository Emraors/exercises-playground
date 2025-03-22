package com.example.queue;

import org.junit.jupiter.api.Test;

import static com.example.queue.LeetCodeQueue.RecentCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeQueueTest {

	private final LeetCodeQueue leetCode = new LeetCodeQueue();

	@Test
	public void testRecentCounter() {
		RecentCounter recentCounter = leetCode.getInstance();

		assertEquals(1, recentCounter.ping(1));
		assertEquals(2, recentCounter.ping(100));
		assertEquals(3, recentCounter.ping(3001));
		assertEquals(3, recentCounter.ping(3002));
	}
}