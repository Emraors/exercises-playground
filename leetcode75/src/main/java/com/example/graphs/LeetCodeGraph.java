package com.example.graphs;

import java.util.*;

public class LeetCodeGraph {

	// First solution I wrote
	public boolean canVisitAllRoomsFirstSolution(List<List<Integer>> rooms) {
		Stack<Integer> keys = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		int numberOfRooms = rooms.size();

		keys.addAll(rooms.getFirst());
		visited.add(0);

		while (!keys.isEmpty()) {
			Integer roomKey = keys.pop();
			keys.addAll(rooms.get(roomKey));
			rooms.set(roomKey, new ArrayList<>());
			visited.add(roomKey);
		}

		return visited.size() == numberOfRooms;
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int numberOfRooms = rooms.size();
		boolean[] visited = new boolean[numberOfRooms];

		dfs(rooms, 0, visited);

		boolean result = true;
		for (boolean b : visited)
			result = b && result;
		return result;
	}

	private void dfs(List<List<Integer>> rooms, int roomKey, boolean[] visited) {
		visited[roomKey] = true;
		for (Integer adj : rooms.get(roomKey)) {
			if (!visited[adj]) {
				dfs(rooms, adj, visited);
			}
		}
	}

}
