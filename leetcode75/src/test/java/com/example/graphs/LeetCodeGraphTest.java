package com.example.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeGraphTest {

	private static final char LEFT_BRAKET = '[';
	private static final char RIGHT_BRAKET = ']';
	private static final Pattern NUMBERS = Pattern.compile("\\d+");
	private final LeetCodeGraph leetCode = new LeetCodeGraph();

	@Test
	void parseMatrixAsArrayTest() {
		String firstTest = "[[1,1,0],[1,1,0],[0,0,1]]";
		String secondTest = "[]";

		assertEquals(List.of(List.of(1, 1, 0), List.of(1, 1, 0), List.of(0, 0, 1)),
				parseStringMatrixAsList(firstTest, this::parseListInt));
		assertEquals(List.of(), parseStringMatrixAsList(secondTest, this::parseListInt));
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
		List<List<String>> firstEquations = parseStringMatrixAsList("[['a','b'],['b','c']", this::parseListSting);
		List<List<String>> firstQueries = parseStringMatrixAsList(
				"[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]", this::parseListSting);
		double[] firstValues = new double[] { 2.0, 3.0 };

		List<List<String>> secondEquations = parseStringMatrixAsList("[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]",
				this::parseListSting);
		List<List<String>> secondQueries = parseStringMatrixAsList(
				"[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]",
				this::parseListSting);
		double[] secondValues = new double[] { 1.5, 2.5, 5.0 };

		List<List<String>> thirdEquations = parseStringMatrixAsList("[[\"a\",\"b\"]]", this::parseListSting);
		List<List<String>> thirdQueries = parseStringMatrixAsList(
				"[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]", this::parseListSting);
		double[] thirdValues = new double[] { 0.5 };

		assertArrayEquals(new double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 },
				leetCode.calcEquation(firstEquations, firstValues, firstQueries));
		assertArrayEquals(new double[] { 3.75000, 0.40000, 5.00000, 0.20000 },
				leetCode.calcEquation(secondEquations, secondValues, secondQueries));
		assertArrayEquals(new double[] { 0.50000, 2.00000, -1.00000, -1.00000 },
				leetCode.calcEquation(thirdEquations, thirdValues, thirdQueries));
	}

	private int[][] parseMatrixAsArray(String matrixAsString) {
		return fromListOfListToArrayOfArray(parseStringMatrixAsList(matrixAsString, this::parseListInt));
	}

	private int[][] fromListOfListToArrayOfArray(List<List<Integer>> list) {
		return list.stream()
				.map(this::fromListToArray)
				.toArray(int[][]::new);
	}

	private int[] fromListToArray(List<Integer> list) {
		return list.stream().mapToInt(integer -> integer).toArray();
	}

	private <T> List<List<T>> parseStringMatrixAsList(String matrixAsString, Function<String, List<T>> parser) {
		List<List<T>> result = new ArrayList<>();

		for (int i = 1; i < matrixAsString.length() - 1; ) {
			if (matrixAsString.charAt(i) == LEFT_BRAKET) {
				StringBuilder builder = new StringBuilder();
				while (i < matrixAsString.length() && matrixAsString.charAt(i) != RIGHT_BRAKET) {
					builder.append(matrixAsString.charAt(i));
					i++;
				}
				builder.append(matrixAsString.charAt(i));
				String string = builder.toString();
				result.add(parser.apply(string));
			}
			i++;
		}

		return result;
	}

	private List<String> parseListSting(String listAsString) {
		if (listAsString == null)
			return List.of();
		String s = listAsString.trim();
		if (s.length() < 2 || s.charAt(0) != LEFT_BRAKET || s.charAt(s.length() - 1) != RIGHT_BRAKET) {
			return List.of();
		}
		String inner = s.substring(1, s.length() - 1);
		Pattern quoted = Pattern.compile("['\"]([^'\"]*)['\"]");
		java.util.regex.Matcher m = quoted.matcher(inner);
		List<String> out = new ArrayList<>();
		while (m.find()) {
			out.add(m.group(1));
		}
		if (out.isEmpty()) {
			for (String token : inner.split(",")) {
				String t = token.trim();
				if (!t.isEmpty())
					out.add(t);
			}
		}
		return out;
	}

	private List<Integer> parseListInt(String listAsString) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < listAsString.length(); ) {
			if (Character.isDigit(listAsString.charAt(i))) {
				int num = 0;
				while (i < listAsString.length() && Character.isDigit(listAsString.charAt(i))) {
					num = num * 10 + (listAsString.charAt(i) - '0');
					i++;
				}
				result.add(num);
			}
			i++;
		}
		return result;
	}

	private List<Integer> parseListWitRegEx(String input) {
		return NUMBERS
				.matcher(input)
				.results()
				.map(MatchResult::group)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

}