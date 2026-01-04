package com.example.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestInfiniteSetTest {

	private SmallestInfiniteSet set;

	@Test
	void testInitialSequence() {
		set = new SmallestInfiniteSet();

		assertEquals(1, set.popSmallest());
		assertEquals(2, set.popSmallest());
		assertEquals(3, set.popSmallest());
		assertEquals(4, set.popSmallest());
	}

	@Test
	void testAddBackSingle() {
		set = new SmallestInfiniteSet();

		assertEquals(1, set.popSmallest());
		assertEquals(2, set.popSmallest());

		set.addBack(1);

		// Now 1 should come back before 3
		assertEquals(1, set.popSmallest());
		assertEquals(3, set.popSmallest());
	}

	@Test
	void testAddBackDuplicateNoEffect() {
		set = new SmallestInfiniteSet();

		assertEquals(1, set.popSmallest());
		assertEquals(2, set.popSmallest());

		set.addBack(1);
		set.addBack(1); // should NOT be inserted twice

		assertEquals(1, set.popSmallest());
		assertEquals(3, set.popSmallest());
	}

	@Test
	void testAddBackLargerThanCurrentIgnored() {
		set = new SmallestInfiniteSet();

		assertEquals(1, set.popSmallest());
		assertEquals(2, set.popSmallest());
		assertEquals(3, set.popSmallest());

		set.addBack(10); // should be ignored

		assertEquals(4, set.popSmallest());
	}

	@Test
	void testMixedOperations() {
		set = new SmallestInfiniteSet();

		assertEquals(1, set.popSmallest());
		assertEquals(2, set.popSmallest());

		set.addBack(1);  // add back 1
		set.addBack(3);  // add back 3 (but current is 3, so ignored)

		assertEquals(1, set.popSmallest()); // returns from heap
		assertEquals(3, set.popSmallest()); // now current = 3
		assertEquals(4, set.popSmallest());
	}

	@Test
	void testStress() {
		set = new SmallestInfiniteSet();

		for (int i = 1; i <= 1000; i++) {
			assertEquals(i, set.popSmallest());
		}

		set.addBack(10);
		set.addBack(5);
		set.addBack(999);

		assertEquals(5, set.popSmallest());
		assertEquals(10, set.popSmallest());
		assertEquals(999, set.popSmallest());
		assertEquals(1001, set.popSmallest());
	}
}
