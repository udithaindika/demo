package com.uditha.autogeneral.utils;

import java.util.Stack;

public class BracketsUtil {

	public static boolean isValidBrackets(String input) {
		if (input == null || input.trim().isEmpty()) {
			return true;
		}

		Stack<Character> brackets = new Stack<>();

		for (Character charVal : input.toCharArray()) {
			if (charVal == '{' || charVal == '[' || charVal == '(') {
				brackets.add(charVal);
			} else if (charVal == '}' || charVal == ']' || charVal == ')') {
				if (brackets.size() == 0) {
					return false;
				}
				Character lastBracket = brackets.pop();
				if (!isMatchingBracket(lastBracket, charVal)) {
					return false;
				}
			}
		}

		return brackets.size() == 0;
	}

	private static boolean isMatchingBracket(char start, char end) {
		if (start == '{' && end == '}') {
			return true;
		} else if (start == '[' && end == ']') {
			return true;
		} else if (start == '(' && end == ')') {
			return true;
		}

		return false;
	}

}
