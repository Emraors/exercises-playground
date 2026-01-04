package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCodeStack {

	public int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> resultDeque = new ArrayDeque<>();

		for (int a : asteroids) {
			if (a > 0) {
				resultDeque.push(a);
			} else {
				while (!resultDeque.isEmpty() && resultDeque.peek() > 0 && resultDeque.peek() < Math.abs(a)) {
					resultDeque.pop();
				}
				if (resultDeque.isEmpty() || resultDeque.peek() < 0) {
					resultDeque.push(a);
				} else if (resultDeque.peek() == Math.abs(a)) {
					resultDeque.pop();
				}
			}
		}
		int length = resultDeque.size();
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = resultDeque.removeLast();
		}
		return result;
	}

	public String removeStars(String s) {
		StringBuilder result = new StringBuilder();
		Stack<Character> characterStack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '*') {
				characterStack.pop();
			} else
				characterStack.push(c);
		}
		characterStack.forEach(result::append);
		return result.toString();
	}

	public String decodeString(String s) {
		State state = new State();
		Stack<State> stateStack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (Character.isLetter(c))
				state.builder.append(c);
			if (Character.isDigit(c))
				state.multiplier = (state.multiplier * 10 + (c - '0'));
			if (c == '[') {
				stateStack.push(state);
				state = new State();
			}
			if (c == ']') {
				State currentState = stateStack.pop();
				for (int i = 0; i < currentState.multiplier; i++) {
					currentState.builder.append(state.builder);
				}
				state.builder = currentState.builder;
			}
		}
		return state.builder.toString();
	}

	private static class State {
		private StringBuilder builder;
		private int multiplier;

		public State() {
			this.builder = new StringBuilder();
			this.multiplier = 0;
		}
	}
}
