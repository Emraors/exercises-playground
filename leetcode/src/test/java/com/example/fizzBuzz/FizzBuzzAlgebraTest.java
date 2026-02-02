package com.example.fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzAlgebraTest {

	private final FizzBuzzAlgebra fizzBuzzer = FizzBuzzAlgebra.builder()
			.addRule(3, "Fizz")
			.addRule(5, "Buzz")
			.build();

	@Test
	public void testFizzBuzz() {
		String fizzBuzz = fizzBuzzer.fizzBuzz(15);

		assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz", fizzBuzz);
	}
}