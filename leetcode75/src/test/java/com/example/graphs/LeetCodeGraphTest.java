package com.example.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeetCodeGraphTest {

	LeetCodeGraph leetCode = new LeetCodeGraph();

	@Test
	void canVisitAllRoomsTest() {
		List<List<Integer>> firstTest = Arrays.asList(List.of(1), List.of(2), List.of(3), new ArrayList<>());
		List<List<Integer>> secondTest = new ArrayList<>(
				Arrays.asList(List.of(1, 3), List.of(3, 0, 1), List.of(2), new ArrayList<>()));

		assertTrue(leetCode.canVisitAllRooms(firstTest));
		assertFalse(leetCode.canVisitAllRooms(secondTest));
	}
}