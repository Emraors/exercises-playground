package com.example.trie;

public interface TrieInt {

	void insert(String word);

	boolean search(String word);

	boolean startsWith(String prefix);
}
