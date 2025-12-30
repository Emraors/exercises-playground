package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class TestUtils {

	private static final char LEFT_BRAKET = '[';
	private static final char RIGHT_BRAKET = ']';
	private static final Pattern NUMBERS = Pattern.compile("\\d+");

	public static int[][] parseMatrixAsArray(String matrixAsString) {
		return fromListOfListToArrayOfArray(parseStringMatrixAsList(matrixAsString, TestUtils::parseListInt));
	}

	public static char[][] parseMatrixAsCharArray(String matrixAsString) {
		return fromListOfListToArrayOfArrayChar(parseStringMatrixAsList(matrixAsString, TestUtils::parseListSting));
	}

	public static int[][] fromListOfListToArrayOfArray(List<List<Integer>> list) {
		return list.stream()
				.map(l -> l.stream().mapToInt(integer -> integer).toArray())
				.toArray(int[][]::new);
	}

	public static char[][] fromListOfListToArrayOfArrayChar(List<List<String>> list) {
		char[][] charMatrix = new char[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			List<String> row = list.get(i);
			charMatrix[i] = new char[row.size()];
			for (int j = 0; j < row.size(); j++) {
				charMatrix[i][j] = stringAsChar(row.get(j));
			}
		}
		return charMatrix;
	}

	public static char stringAsChar(String charString) {
		char[] charArray = charString.toCharArray();
		if (charArray.length > 1)
			throw new IllegalArgumentException("Only applicable to a string of length 1");
		return charArray.length == 0 ? Character.MIN_VALUE : charArray[0];
	}

/*	private int[] fromListToArray(List<Integer> list) {
		return list.stream().mapToInt(integer -> integer).toArray();
	}*/

	public static <T> List<List<T>> parseStringMatrixAsList(String matrixAsString, Function<String, List<T>> parser) {
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

	public static List<String> parseListSting(String listAsString) {
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

	public static List<Integer> parseListInt(String listAsString) {
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
}
