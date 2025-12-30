package com.example.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCodeIntervals {

	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

		int removed = 0;
		int lastEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= lastEnd) {
				lastEnd = intervals[i][1];
			} else {
				removed++;
			}
		}
		return removed;
	}

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;
		Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

		int hit = 1;
		int pos = points[0][1];

		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > pos) {
				pos = points[i][1];
				hit++;
			}
		}
		return hit;
	}
}
