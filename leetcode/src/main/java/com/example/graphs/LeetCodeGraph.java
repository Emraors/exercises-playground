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
		Map<String, List<WeightedNode>> adjList = fromEquationsToAdjList(equations, values);
		double[] results = new double[queries.size()];
		int i = 0;
		for (List<String> query : queries) {
			String start = query.get(0);
			String end = query.get(1);

			if (!adjList.containsKey(start) || !adjList.containsKey(end)) {
				results[i++] = -1.0;
				continue;
			}
			results[i++] = findProduct(adjList, start, end, 1.0, new HashMap<>());
		}
		return results;
	}

	private double findProduct(Map<String, List<WeightedNode>> adjList, String current, String endNode,
			double partialResult, Map<String, Boolean> visited) {
		if (current.equals(endNode))
			return partialResult;

		visited.put(current, true);

		for (WeightedNode next : adjList.getOrDefault(current, List.of())) {
			if (!visited.getOrDefault(next.nodeName(), false)) {
				double result = findProduct(adjList, next.nodeName(), endNode, partialResult * next.weight(), visited);
				if (result != -1.0) {
					return result;
				}
			}
		}
		return -1.0;
	}

	private Map<String, List<WeightedNode>> fromEquationsToAdjList(List<List<String>> equations, double[] values) {
		Map<String, List<WeightedNode>> adjList = new HashMap<>();
		for (int i = 0; i < values.length; i++) {
			List<String> eq = equations.get(i);
			String dividend = eq.getFirst(), divisor = eq.get(1);

			adjList.computeIfAbsent(dividend, k -> new ArrayList<>()).add(new WeightedNode(divisor, values[i]));
			adjList.computeIfAbsent(divisor, k -> new ArrayList<>()).add(new WeightedNode(dividend, 1 / values[i]));
		}
		return adjList;
	}

	public int nearestExit(char[][] maze, int[] entrance) {
		int nRows = maze.length;
		int nCol = maze[0].length;

		Queue<Coordinate> queue = new ArrayDeque<>();
		Set<Coordinate> visited = new HashSet<>();

		Coordinate start = new Coordinate(entrance[0], entrance[1]);
		queue.add(start);
		visited.add(start);

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Coordinate current = queue.poll();
				int r = current.row();
				int c = current.col();
				if (!(r == start.row() && c == start.col()) && (r == 0 || r == nRows - 1 || c == 0 || c == nCol - 1)) {
					return steps;
				}

				Coordinate[] neighbors = { current.moveRow(1), current.moveRow(-1), current.moveColumn(1),
						current.moveColumn(-1) };

				for (Coordinate next : neighbors) {
					int nextRow = next.row();
					int nextCol = next.col();

					if (nextRow >= 0 && nextRow < nRows && nextCol >= 0 && nextCol < nCol && maze[nextRow][nextCol] == '.' && !visited.contains(
							next)) {

						visited.add(next);
						queue.add(next);
					}
				}
			}
			steps++;
		}
		return -1;
	}

	//Versione ottimizzata (chat gpt):
	public int nearestExitFaster(char[][] maze, int[] entrance) {
		int n = maze.length;
		int m = maze[0].length;

		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { entrance[0], entrance[1] });
		visited[entrance[0]][entrance[1]] = true;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				int r = cell[0];
				int c = cell[1];

				if (!(r == entrance[0] && c == entrance[1]) && (r == 0 || r == n - 1 || c == 0 || c == m - 1)) {
					return steps;
				}
				for (int[] d : dirs) {
					int nr = r + d[0];
					int nc = c + d[1];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
			steps++;
		}
		return -1;
	}

	public int orangesRotting(int[][] grid) {
		int nRows = grid.length;
		int nCol = grid[0].length;

		Queue<int[]> rottenOranges = new ArrayDeque<>();

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int steps = 0, nFreshOranges = 0;

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCol; j++) {
				int gridValue = grid[i][j];
				if (gridValue == 1)
					nFreshOranges++;
				if (gridValue == 2)
					rottenOranges.add(new int[] { i, j });
			}
		}

		if (nFreshOranges == 0)
			return 0;

		while (!rottenOranges.isEmpty()) {
			boolean convertedThisMinute = false;
			int size = rottenOranges.size();

			for (int i = 0; i < size; i++) {
				int[] rottenOrange = rottenOranges.poll();
				int row = rottenOrange[0], col = rottenOrange[1];

				for (int[] d : dirs) {
					int nr = row + d[0];
					int nc = col + d[1];
					if (nr >= 0 && nr < nRows && nc >= 0 && nc < nCol && grid[nr][nc] == 1) {
						grid[nr][nc] = 2;
						rottenOranges.add(new int[] { nr, nc });
						nFreshOranges--;
						convertedThisMinute = true;
					}
				}
			}
			if (convertedThisMinute)
				steps++;
		}
		return nFreshOranges == 0 ? steps : -1;
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;

		int nRows = grid.length;
		int nColumns = grid[0].length;
		boolean[][] visited = new boolean[nRows][nColumns];
		int nIslands = 0;

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					exploreIsland(grid, visited, i, j);
					nIslands++;
				}
			}
		}

		return nIslands;
	}

	private void exploreIsland(char[][] grid, boolean[][] visited, int rowIndex, int colIndex) {
		int rows = grid.length;
		int cols = grid[0].length;

		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { rowIndex, colIndex });
		visited[rowIndex][colIndex] = true;

		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!stack.isEmpty()) {
			int[] cell = stack.pop();
			int row = cell[0];
			int col = cell[1];

			for (int[] d : directions) {
				int nr = row + d[0];
				int nc = col + d[1];

				if (nr >= 0 && nr < rows &&
						nc >= 0 && nc < cols &&
						grid[nr][nc] == '1' &&
						!visited[nr][nc]) {

					visited[nr][nc] = true;
					stack.push(new int[] { nr, nc });
				}
			}
		}
	}

	private record Coordinate(int row, int col) {
		public Coordinate moveRow(int quantity) {
			return new Coordinate(row + quantity, col);
		}

		public Coordinate moveColumn(int quantity) {
			return new Coordinate(row, col + quantity);
		}
	}

	private record WeightedNode(String nodeName, double weight) {
	}
}
