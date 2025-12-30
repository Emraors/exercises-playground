package com.example.intervals;

import org.junit.jupiter.api.Test;

import static com.example.TestUtils.parseMatrixAsArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCodeIntervalsTest {

	private final LeetCodeIntervals leetCode = new LeetCodeIntervals();

	@Test
	void testEraseOverlapIntervals() {
		int[][] firstTest = parseMatrixAsArray("[[1,2],[2,3],[3,4],[1,3]]");
		int[][] secondTest = parseMatrixAsArray("[[1,2],[1,2],[1,2]]");
		int[][] thirdTest = parseMatrixAsArray("[[1,2],[2,3]]");

		assertEquals(1, leetCode.eraseOverlapIntervals(firstTest));
		assertEquals(2, leetCode.eraseOverlapIntervals(secondTest));
		assertEquals(0, leetCode.eraseOverlapIntervals(thirdTest));
	}

	@Test
	void testFindMinArrowShots() {
		int[][] firstTest = parseMatrixAsArray("[[10,16],[2,8],[1,6],[7,12]]");
		int[][] secondTest = parseMatrixAsArray("[[1,2],[3,4],[5,6],[7,8]]");
		int[][] thirdTest = parseMatrixAsArray("[[1,2],[2,3],[3,4],[4,5]]");
		int[][] fourthTest = parseMatrixAsArray("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]");

		assertEquals(2, leetCode.findMinArrowShots(firstTest));
		assertEquals(4, leetCode.findMinArrowShots(secondTest));
		assertEquals(2, leetCode.findMinArrowShots(thirdTest));
		assertEquals(2, leetCode.findMinArrowShots(fourthTest));
	}
}