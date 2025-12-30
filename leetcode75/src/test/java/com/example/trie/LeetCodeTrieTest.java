package com.example.trie;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeetCodeTrieTest {

	@Test
	void exampleFromLeetCode() {
		LeetCodeTrie s = new LeetCodeTrie();
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		List<List<String>> out = s.suggestedProducts(products, searchWord);

		assertEquals(List.of("mobile", "moneypot", "monitor"), out.get(0));
		assertEquals(List.of("mobile", "moneypot", "monitor"), out.get(1));
		assertEquals(List.of("mouse", "mousepad"), out.get(2));
		assertEquals(List.of("mouse", "mousepad"), out.get(3));
		assertEquals(List.of("mouse", "mousepad"), out.get(4));
	}

	@Test
	void handlesNoMatchesAndEdgeChars() {
		LeetCodeTrie s = new LeetCodeTrie();
		String[] products = { "a", "b", "aa", "ab", "zzz" };
		List<List<String>> out = s.suggestedProducts(products, "c");
		assertEquals(1, out.size());
		assertTrue(out.get(0).isEmpty());

		out = s.suggestedProducts(products, "az");
		assertEquals(List.of(List.of("a", "aa", "ab"), List.of()), out);
	}

	@Test
	void emptySearchWordProducesEmptyResult() {
		LeetCodeTrie s = new LeetCodeTrie();
		List<List<String>> out = s.suggestedProducts(new String[] { "a", "b" }, "");
		assertTrue(out.isEmpty());
	}
}
