package com.example.graphs;

import com.example.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class LeetCodeGraphTest {

	private final LeetCodeGraph leetCode = new LeetCodeGraph();

	@Test
	void parseMatrixAsArrayTest() {
		String firstTest = "[[1,1,0],[1,1,0],[0,0,1]]";
		String secondTest = "[]";

		assertEquals(List.of(List.of(1, 1, 0), List.of(1, 1, 0), List.of(0, 0, 1)),
				parseStringMatrixAsList(firstTest, TestUtils::parseListInt));
		assertEquals(List.of(), parseStringMatrixAsList(secondTest, TestUtils::parseListInt));
	}

	@Test
	void canVisitAllRoomsTest() {
		List<List<Integer>> firstTest = Arrays.asList(List.of(1), List.of(2), List.of(3), new ArrayList<>());
		List<List<Integer>> secondTest = new ArrayList<>(
				Arrays.asList(List.of(1, 3), List.of(3, 0, 1), List.of(2), new ArrayList<>()));

		assertTrue(leetCode.canVisitAllRooms(firstTest));
		assertFalse(leetCode.canVisitAllRooms(secondTest));
	}

	@Test
	void findCircleNumTest() {
		int[][] firstTest = parseMatrixAsArray("[[1,1,0],[1,1,0],[0,0,1]]");
		int[][] secondTest = parseMatrixAsArray("[[1,0,0],[0,1,0],[0,0,1]]");
		int[][] thirdTest = parseMatrixAsArray("[]");
		int[][] fourthTest = parseMatrixAsArray(
				"[[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,1,0,1,0,0,0,0,0,0,0,0,0,1,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],[0,1,0,1,0,0,0,1,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,1,1,0,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0,0,0],[0,0,0,1,0,0,0,0,0,0,0,1,0,0,0],[0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],[0,1,0,0,0,0,0,0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]]");

		assertEquals(2, leetCode.findCircleNum(firstTest));
		assertEquals(3, leetCode.findCircleNum(secondTest));
		assertEquals(0, leetCode.findCircleNum(thirdTest));
		assertEquals(8, leetCode.findCircleNum(fourthTest));
	}

	@Test
	void minReorderTest() {
		int[][] firstTest = parseMatrixAsArray(
				"[[0,1],[1,3],[2,3],[4,0],[4,5]]"); // ---> [1,0] (flipped), [3,1] (flipped), [2,3], [4,0], [5,4] (flipped)
		int[][] secondTest = parseMatrixAsArray("[[1,0],[1,2],[3,2],[3,4]]");
		int[][] thirdTest = parseMatrixAsArray("[[1,0],[2,0]]");

		assertEquals(3, leetCode.minReorder(6, firstTest));
		assertEquals(2, leetCode.minReorder(5, secondTest));
		assertEquals(0, leetCode.minReorder(3, thirdTest));
	}

	@Test
	void calcEquationTest() {
		List<List<String>> firstEquations = parseStringMatrixAsList("[['a','b'],['b','c']", TestUtils::parseListSting);
		List<List<String>> firstQueries = parseStringMatrixAsList(
				"[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]", TestUtils::parseListSting);
		double[] firstValues = new double[] { 2.0, 3.0 };

		List<List<String>> secondEquations = parseStringMatrixAsList("[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]",
				TestUtils::parseListSting);
		List<List<String>> secondQueries = parseStringMatrixAsList(
				"[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]",
				TestUtils::parseListSting);
		double[] secondValues = new double[] { 1.5, 2.5, 5.0 };

		List<List<String>> thirdEquations = parseStringMatrixAsList("[[\"a\",\"b\"]]", TestUtils::parseListSting);
		List<List<String>> thirdQueries = parseStringMatrixAsList(
				"[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]", TestUtils::parseListSting);
		double[] thirdValues = new double[] { 0.5 };

		assertArrayEquals(new double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 },
				leetCode.calcEquation(firstEquations, firstValues, firstQueries));
		assertArrayEquals(new double[] { 3.75000, 0.40000, 5.00000, 0.20000 },
				leetCode.calcEquation(secondEquations, secondValues, secondQueries));
		assertArrayEquals(new double[] { 0.50000, 2.00000, -1.00000, -1.00000 },
				leetCode.calcEquation(thirdEquations, thirdValues, thirdQueries));
	}

	@Test
	void nearestExitTest() {
		char[][] firstTest = parseMatrixAsCharArray("[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"]");
		char[][] secondTest = parseMatrixAsCharArray("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]");
		char[][] testTest = parseMatrixAsCharArray("[[\".\",\"+\"]]");

		assertEquals(1, leetCode.nearestExit(firstTest, new int[] { 1, 2 }));
		assertEquals(2, leetCode.nearestExit(secondTest, new int[] { 1, 0 }));
		assertEquals(-1, leetCode.nearestExit(testTest, new int[] { 0, 0 }));
	}

	@Test
	void orangesRottingTest() {
		int[][] firstTest = parseMatrixAsArray("[[2,1,1],[1,1,0],[0,1,1]]");
		int[][] secondTest = parseMatrixAsArray("[[2,1,1],[0,1,1],[1,0,1]]");
		int[][] thirdTest = parseMatrixAsArray("[[0,2]]");

		assertEquals(4, leetCode.orangesRotting(firstTest));
		assertEquals(-1, leetCode.orangesRotting(secondTest));
		assertEquals(0, leetCode.orangesRotting(thirdTest));
	}

	@Test
	void testNumIslands() {
		char[][] firstTest = parseMatrixAsCharArray("[\n" +
				"  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
				"  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
				"  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
				"  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
				"]");
		char[][] secondTest = parseMatrixAsCharArray("[\n" +
				"  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
				"  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
				"  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
				"  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
				"]");

		assertEquals(1, leetCode.numIslands(firstTest));
		assertEquals(3, leetCode.numIslands(secondTest));
	}
}