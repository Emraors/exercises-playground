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

	private void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
		visited[index] = true;
		for (Integer adj : rooms.get(index)) {
			if (!visited[adj]) {
				dfs(rooms, adj, visited);
			}
		}
	}

	private void dfsMatrixRecursive(int[][] adjMatrix, int vertex, boolean[] visited) {
		visited[vertex] = true;
		for (int i = 0; i < adjMatrix[vertex].length; i++) {
			if (adjMatrix[vertex][i] == 1 && !visited[i]) {
				dfsMatrixRecursive(adjMatrix, i, visited);
			}
		}
	}

	private void dfsMatrixIterative(int[][] adjMatrix, int vertex, boolean[] visited) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(vertex);
		visited[vertex] = true;
		while (!stack.isEmpty()) {
			int v = stack.pop();
			for (int j = 0; j < adjMatrix[v].length; j++) {
				if (adjMatrix[v][j] == 1 && !visited[j]) {
					visited[j] = true;
					stack.push(j);
				}
			}
		}
	}

	private void bfsMatrix(int[][] adjMatrix, int start, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int j = 0; j < adjMatrix[v].length; j++) {
				if (adjMatrix[v][j] == 1 && !visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}
	}

	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		if (n == 0)
			return 0;
		boolean[] visited = new boolean[n];
		int components = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfsMatrixRecursive(isConnected, i, visited);
				components++;
			}
		}
		return components;
	}

	/*public Map<Integer, List<Integer>> fromEdgeListToAdjList(int[][] edgeList) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int[] edge : edgeList) {
			adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
			adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
		}
		return adjList;
	}*/

	public int minReorder(int n, int[][] connections) {
		if (n == 0)
			return 0;

		Map<Integer, List<int[]>> adjList = fromEdgeListToAdjList(n, connections);
		boolean[] visited = new boolean[n];
		return dfsAdjList(adjList, 0, visited);
	}

	private int dfsAdjList(Map<Integer, List<int[]>> adjList, Integer node, boolean[] visited) {
		visited[node] = true;
		int count = 0;
		for (int[] neighbor : adjList.get(node)) {
			int next = neighbor[0], needsReversal = neighbor[1];
			if (!visited[next]) {
				count += needsReversal;
				count += dfsAdjList(adjList, next, visited);
			}
		}
		return count;
	}

	private Map<Integer, List<int[]>> fromEdgeListToAdjList(int n, int[][] connections) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int i = 0; i < n; i++)
			graph.put(i, new ArrayList<>());

		for (int[] conn : connections) {
			int from = conn[0], to = conn[1];
			graph.get(from).add(new int[] { to, 1 });
			graph.get(to).add(new int[] { from, 0 });
		}
		return graph;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		return new double[] {};
	}
}
