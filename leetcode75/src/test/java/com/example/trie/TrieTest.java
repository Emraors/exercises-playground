package com.example.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

	TrieInt trie;

	@BeforeEach
	void setup() {
		trie = new HashMapTrie();
	}

	@Test
	void leetCodeExample() {
		trie.insert("apple");

		assertTrue(trie.search("apple"));
		assertFalse(trie.search("app"));
		assertTrue(trie.startsWith("app"));

		trie.insert("app");
		assertTrue(trie.search("app"));
	}

	@Test
	void duplicateInsertIsFine() {
		trie.insert("app");
		trie.insert("app");
		trie.insert("app");

		assertTrue(trie.search("app"));
		assertTrue(trie.startsWith("a"));
		assertFalse(trie.search("ap"));
	}

	@Test
	void emptyStringIsSupported() {
		assertFalse(trie.search(""));
		assertTrue(trie.startsWith(""));

		trie.insert("");
		assertTrue(trie.search(""));
		assertTrue(trie.startsWith(""));
	}

	@Test
	void unknownWordsAndTooLongPrefixes() {
		trie.insert("a");
		trie.insert("ab");

		assertFalse(trie.search("abc"));
		assertFalse(trie.startsWith("abc"));
		assertFalse(trie.search("b"));
		assertFalse(trie.startsWith("b"));
	}

	@Test
	void supportsBoundaryLetters() {
		trie.insert("a");
		trie.insert("z");
		trie.insert("az");
		trie.insert("za");

		assertTrue(trie.search("a"));
		assertTrue(trie.search("z"));
		assertTrue(trie.search("az"));
		assertTrue(trie.search("za"));

		assertFalse(trie.search("aa"));
		assertFalse(trie.search("zz"));
		assertTrue(trie.startsWith("a"));
		assertTrue(trie.startsWith("z"));
		assertFalse(trie.startsWith("zza"));
	}

	@Test
	void rejectsNullInputs() {
		assertThrows(IllegalArgumentException.class, () -> trie.insert(null));
		assertThrows(IllegalArgumentException.class, () -> trie.search(null));
		assertThrows(IllegalArgumentException.class, () -> trie.startsWith(null));
	}

/*	@Test
	void rejectsNonLowercaseCharacters() {
		assertThrows(IllegalArgumentException.class, () -> trie.insert("A"));
		assertThrows(IllegalArgumentException.class, () -> trie.insert("a-b"));
		assertThrows(IllegalArgumentException.class, () -> trie.search("Hello"));
		assertThrows(IllegalArgumentException.class, () -> trie.startsWith("!"));
	}*/
}