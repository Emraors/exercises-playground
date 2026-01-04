package com.example.two_pointers;

import java.util.Map;
import java.util.function.BiFunction;

public class StateMachineExperiment {

	private static final Map<SymbolKind, BiFunction<Character, Character, Transition>> TABLE = Map.of(
			SymbolKind.BOTH_ALNUM,
			(l, r) -> (l == r) ? new Transition(+1, -1, Control.SCAN) : new Transition(0, 0, Control.FAIL),

			SymbolKind.LEFT_ONLY, (l, r) -> new Transition(0, -1, Control.SCAN), SymbolKind.RIGHT_ONLY,
			(l, r) -> new Transition(+1, 0, Control.SCAN), SymbolKind.NONE,
			(l, r) -> new Transition(+1, -1, Control.SCAN));

	public boolean isPalindrome(String s) {
		char[] chars = s.toLowerCase().toCharArray();

		PalindromeState state = new PalindromeState(0, chars.length - 1, Control.SCAN);

		while (!state.done()) {
			state = step(state, chars);
		}

		return state.isSuccess();
	}

	private SymbolKind symbols(PalindromeState s, char[] chars) {
		return classify(chars[s.left], chars[s.right]);
	}

	private boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}

	private PalindromeState step(PalindromeState s, char[] chars) {
		if (s.control == Control.FAIL)
			return s;

		char l = chars[s.left];
		char r = chars[s.right];

		SymbolKind kind = symbols(s, chars);
		Transition t = TABLE.get(kind).apply(l, r);

		return new PalindromeState(s.left + t.dl(), s.right + t.dr(), t.control());
	}

	private SymbolKind classify(char l, char r) {
		boolean la = isAlphaNumeric(l);
		boolean ra = isAlphaNumeric(r);

		if (la && ra)
			return SymbolKind.BOTH_ALNUM;
		if (la)
			return SymbolKind.LEFT_ONLY;
		if (ra)
			return SymbolKind.RIGHT_ONLY;
		return SymbolKind.NONE;
	}

	private enum SymbolKind {
		BOTH_ALNUM, LEFT_ONLY, RIGHT_ONLY, NONE
	}

	enum Control {
		SCAN, FAIL
	}

	private record Transition(int dl, int dr, Control control) {
	}

	private record PalindromeState(int left, int right, Control control) {

		boolean done() {
			return control == Control.FAIL || left >= right;
		}

		boolean isSuccess() {
			return control != Control.FAIL;
		}
	}

}
