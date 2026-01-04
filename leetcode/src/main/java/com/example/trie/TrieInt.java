package com.example.trie;

import java.util.List;

public interface TrieInt {

	void insert(String word);

	boolean search(String word);

	boolean startsWith(String prefix);

	List<String> withPrefix(String prefix);
}
