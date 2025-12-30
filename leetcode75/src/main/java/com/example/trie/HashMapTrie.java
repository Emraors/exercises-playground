package com.example.trie;

import java.util.HashMap;
import java.util.Map;

public class HashMapTrie implements TrieInt {

	private final TrieNode root;

	public HashMapTrie() {
		this.root = new TrieNode();
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
			char c = word.charAt(i);
			node = node.children.computeIfAbsent(c, k -> new TrieNode());
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		requireNonNull(word);
		TrieNode node = traverse(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String prefix) {
		requireNonNull(prefix);
		return traverse(prefix) != null;
	}

	private TrieNode traverse(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			node = node.children.get(c);
			if (node == null) {
				return null;
			}
		}
		return node;
	}

	private static final class TrieNode {
		private final Map<Character, TrieNode> children = new HashMap<>();
		private boolean isWord;
	}
}
