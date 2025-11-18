package com.example.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeGraphTest {

	private static final char SEPARATOR = ',';
	private static final char LEFT_BRAKET = '[';
	private static final char RIGHT_BRAKET = ']';
	private static final Pattern NUMBERS = Pattern.compile("\\d+");
	private final LeetCodeGraph leetCode = new LeetCodeGraph();

	@Test
	void parseMatrixAsArrayTest() {
		String firstTest = "[[1,1,0],[1,1,0],[0,0,1]]";
		String secondTest = "[]";

		assertEquals(List.of(List.of(1, 1, 0), List.of(1, 1, 0), List.of(0, 0, 1)), parseMatrixAsList(firstTest));
		assertEquals(List.of(), parseMatrixAsList(secondTest));
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

		assertEquals(2, leetCode.findCircleNum(firstTest));
		assertEquals(3, leetCode.findCircleNum(secondTest));
	}

	private int[][] parseMatrixAsArray(String matrixAsString) {
		return fromListOfListToArrayOfArray(parseMatrixAsList(matrixAsString));
	}

	private int[][] fromListOfListToArrayOfArray(List<List<Integer>> list) {
		return list.stream()
				.map(this::fromListToArray)
				.toArray(int[][]::new);
	}

	private int[] fromListToArray(List<Integer> list) {
		return list.stream().mapToInt(integer -> integer).toArray();
	}

	private List<List<Integer>> parseMatrixAsList(String matrixAsString) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 1; i < matrixAsString.length() - 1; ) {
			if (matrixAsString.charAt(i) == LEFT_BRAKET) {
				StringBuilder builder = new StringBuilder();
				while (i < matrixAsString.length() && matrixAsString.charAt(i) != RIGHT_BRAKET) {
					builder.append(matrixAsString.charAt(i));
					i++;
				}
				builder.append(matrixAsString.charAt(i));
				String string = builder.toString();
				result.add(parseList(string));
			}
			i++;
		}

		return result;
	}

	private List<Integer> parseList(String listAsString) {
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