package com.example.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeTrie {

	private final TrieInt trie;

	public LeetCodeTrie(TrieInt trie) {
		this.trie = trie;
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		if (searchWord == null || products == null) {
			throw new IllegalArgumentException("Inputs must not be null");
		}

		Arrays.sort(products);
		for (String p : products) {
			trie.insert(p);
		}

		List<List<String>> result = new ArrayList<>(searchWord.length());
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < searchWord.length(); i++) {
			char c = searchWord.charAt(i);
			prefix.append(c);
			List<String> suggestions = trie.withPrefix(prefix.toString());

			if (suggestions.size() > 3) {
				result.add(suggestions.subList(0, 3));
			} else {
				result.add(suggestions);
			}
		}
		return result;
	}

	public List<List<String>> suggestedProductsBinary(String[] products, String searchWord) {
		Arrays.sort(products);

		List<List<String>> result = new ArrayList<>();
		int left = 0;
		int right = products.length;

		String prefix = "";

		for (char c : searchWord.toCharArray()) {
			prefix += c;

			left = lowerBound(products, prefix, left, right);
			right = lowerBound(products, prefix + Character.MAX_VALUE, left, right);

			List<String> suggestions = new ArrayList<>(
					Arrays.asList(products).subList(left, Math.min(left + 3, right)));
			result.add(suggestions);
		}

		return result;
	}

	private int lowerBound(String[] arr, String target, int lo, int hi) {
		while (lo < hi) {
			int mid = (lo + hi) >>> 1;
			if (arr[mid].compareTo(target) < 0) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

}
