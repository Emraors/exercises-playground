package com.example.monotonic_stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StockSpannerTest {

	@Test
	void exampleFromLeetCode() {
		StockSpanner sp = new StockSpanner();
		int[] inputs = { 100, 80, 60, 70, 60, 75, 85 };
		int[] expected = { 1, 1, 1, 2, 1, 4, 6 };
		int[] out = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			out[i] = sp.next(inputs[i]);
		}
		assertArrayEquals(expected, out);
	}

	@Test
	void strictlyIncreasingPrices() {
		StockSpanner sp = new StockSpanner();
		int[] inputs = { 10, 20, 30, 40 };
		int[] out = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++)
			out[i] = sp.next(inputs[i]);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, out);
	}

	@Test
	void strictlyDecreasingPrices() {
		StockSpanner sp = new StockSpanner();
		int[] inputs = { 40, 30, 20, 10 };
		int[] out = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++)
			out[i] = sp.next(inputs[i]);
		assertArrayEquals(new int[] { 1, 1, 1, 1 }, out);
	}

	@Test
	void equalPrices() {
		StockSpanner sp = new StockSpanner();
		int[] inputs = { 5, 5, 5, 5 };
		int[] out = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++)
			out[i] = sp.next(inputs[i]);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, out);
	}
}

