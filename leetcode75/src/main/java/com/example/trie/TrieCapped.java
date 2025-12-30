package com.example.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieCapped implements TrieInt {

	private final TrieNode root;

	public TrieCapped() {
		this.root = new TrieNode();
	}

	private static int toIndex(char c) {
		if (c < 'a' || c > 'z') {
			throw new IllegalArgumentException("Only lowercase letters a-z are supported. Found: '" + c + "'");
		}
		return c - 'a';
	}

	private static void requireNonNull(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input must not be null");
		}
	}

	public void insert(String word) {
		requireNonNull(word);
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = toIndex(word.charAt(i));

			if (node.children[idx] == null)
				node.children[idx] = new TrieNode();

			node = node.children[idx];

			if (node.suggestions.size() < 3) {
				int sz = node.suggestions.size();
				if (sz == 0 || !node.suggestions.get(sz - 1).equals(word)) {
					node.suggestions.add(word);
				}
			}
		}
		node.isWord = true;
	}

	@Override
	public boolean search(String word) {
		requireNonNull(word);
		TrieNode node = traverse(word);
		return node != null && node.isWord;
	}

	@Override
	public boolean startsWith(String prefix) {
		requireNonNull(prefix);
		return traverse(prefix) != null;
	}

	private TrieNode traverse(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			int idx = toIndex(s.charAt(i));
			node = node.children[idx];
			if (node == null)
				return null;
		}
		return node;
	}

	public List<String> suggestionsForPrefix(String prefix) {
		requireNonNull(prefix);
		TrieNode node = traverse(prefix);
		if (node == null)
			return List.of();
		return new ArrayList<>(node.suggestions);
	}

	private static final class TrieNode {
		private final TrieNode[] children = new TrieNode[26];
		private final List<String> suggestions = new ArrayList<>(3);
		private boolean isWord;
	}
}
