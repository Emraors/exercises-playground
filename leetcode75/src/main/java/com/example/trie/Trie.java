package com.example.trie;

public class Trie implements TrieInt {

	private static final int ALPHABET_SIZE = 26;
	private final TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	private int toIndex(char c) {
		if (c < 'a' || c > 'z') {
			throw new IllegalArgumentException("Only lowercase letters a-z are supported. Found: '" + c + "'");
		}
		return c - 'a';
	}

	private void requireNonNull(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Input must not be null");
		}
	}

	public void insert(String word) {
		requireNonNull(word);
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = toIndex(word.charAt(i));
			TrieNode next = node.children[idx];
			if (next == null) {
				next = new TrieNode();
				node.children[idx] = next;
			}
			node = next;
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
			int idx = toIndex(s.charAt(i));
			node = node.children[idx];
			if (node == null) {
				return null;
			}
		}
		return node;
	}

	private static final class TrieNode {
		private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		private boolean isWord;
	}
}
