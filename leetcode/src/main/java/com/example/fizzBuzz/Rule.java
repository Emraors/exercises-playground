package com.example.fizzBuzz;

@FunctionalInterface
interface Rule {
	static Rule divisibleBy(int divisor, String word) {
		return n -> n % divisor == 0 ? word : "";
	}

	String apply(int n);

	default Rule combine(Rule other) {
		return n -> this.apply(n) + other.apply(n);
	}
}