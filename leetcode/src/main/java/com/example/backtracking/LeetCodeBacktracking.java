package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCodeBacktracking {

	private final Map<String, List<String>> MAP = Map.of("2", List.of("a", "b", "c"), "3", List.of("d", "e", "f"), "4",
			List.of("g", "h", "i"), "5", List.of("j", "k", "l"), "6", List.of("m", "n", "o"), "7",
			List.of("p", "q", "r", "s"), "8", List.of("t", "u", "v"), "9", List.of("w", "x", "y", "z"));

	public List<String> letterCombinationsFirstSolution(String digits) {
		if (digits.isEmpty()) {
			return List.of("");
		}

		var firstNumber = String.valueOf(digits.charAt(0));
		var rest = digits.substring(1);
		List<String> parSolutions = letterCombinationsFirstSolution(rest);

		return MAP.get(firstNumber).stream().flatMap(s -> appendMap(s, parSolutions).stream()).toList();
	}

	private List<String> appendMap(String letter, List<String> list) {
		return list.stream().map(s -> letter + s).toList();
	}

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return List.of("");
		}

		List<String> result = new ArrayList<>();
		char[] buffer = new char[digits.length()];
		dfs(digits, 0, buffer, result);

		return result;
	}

	private void dfs(String digits, int index, char[] buffer, List<String> result) {
		if (index == digits.length()) {
			result.add(new String(buffer));
			return;
		}

		String digit = String.valueOf(digits.charAt(index));
		List<String> letters = MAP.get(digit);

		for (String letter : letters) {
			buffer[index] = letter.charAt(0);
			dfs(digits, index + 1, buffer, result);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		return recursiveBacktracking(k, n, 1);
	}

	private List<List<Integer>> recursiveBacktracking(int k, int n, int index) {
		List<List<Integer>> res = new ArrayList<>();

		if (k == 0 && n == 0) {
			res.add(new ArrayList<>());
			return res;
		}
		if (k == 0 || n < 0 || index > 9) {
			return res;
		}

		for (int i = index; i <= 9; i++) {
			List<List<Integer>> tails = recursiveBacktracking(k - 1, n - i, i + 1);

			prepend(i, tails);
			res.addAll(tails);
		}

		return res;
	}

	private void prepend(int val, List<List<Integer>> list) {
		for (List<Integer> innerList : list) {
			innerList.addFirst(val);
		}
	}

	public List<List<Integer>> combinationSum3ChatGpt(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(k, n, 1, new ArrayList<>(), result);
		return result;
	}

	private void dfs(int k, int remainingSum, int start,
			List<Integer> path,
			List<List<Integer>> result) {

		if (k == 0 && remainingSum == 0) {
			result.add(new ArrayList<>(path));
			return;
		}

		if (k == 0 || remainingSum < 0 || start > 9) {
			return;
		}

		for (int i = start; i <= 9; i++) {
			path.add(i);
			dfs(k - 1, remainingSum - i, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}
}
