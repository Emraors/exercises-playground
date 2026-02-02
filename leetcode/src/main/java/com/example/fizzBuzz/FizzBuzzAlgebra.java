package com.example.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzAlgebra {

	private final Rule rule;

	private FizzBuzzAlgebra(Rule rule) {
		this.rule = rule;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String fizzBuzz(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i > 1) {
				builder.append(", ");
			}
			String result = rule.apply(i);
			builder.append(result.isEmpty() ? i : result);
		}
		return builder.toString();
	}

	public static class Builder {
		private final List<Rule> rules = new ArrayList<>();

		public Builder addRule(Rule rule) {
			this.rules.add(rule);
			return this;
		}

		public Builder addRule(int divisor, String word) {
			this.rules.add(Rule.divisibleBy(divisor, word));
			return this;
		}

		public FizzBuzzAlgebra build() {
			return new FizzBuzzAlgebra(rules.stream()
					.reduce(n -> "", Rule::combine));
		}
	}
}
