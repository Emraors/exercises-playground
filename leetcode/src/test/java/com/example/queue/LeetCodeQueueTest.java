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

	@Test
	public void testPredictPartyVictory() {
		String RADIANT = "Radiant";
		String DIRE = "Dire";

		String firstTest = "RD";
		String secondTest = "RDD";
		String thirdTest = "RRRD";
		String fourthTest = "DDRRR";
		String fifthTest = "DDRRRR";

		assertEquals(RADIANT, leetCode.predictPartyVictory(firstTest));
		assertEquals(DIRE, leetCode.predictPartyVictory(secondTest));
		assertEquals(RADIANT, leetCode.predictPartyVictory(thirdTest));
		assertEquals(DIRE, leetCode.predictPartyVictory(fourthTest));
		assertEquals(RADIANT, leetCode.predictPartyVictory(fifthTest));
	}
}