package com.exp.evala;

import java.util.Stack;

public class InfixToPrefix {

	public static String infixToPrefix(String infix) {
	    Stack<Character> stack = new Stack<>();
	    StringBuilder prefix = new StringBuilder();
	    for (int i = infix.length() - 1; i >= 0; i--) {
	        char c = infix.charAt(i);
	        if (c == '+' || c == '-' || c == '*' || c == '/') {
	            while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
	                prefix.append(stack.pop());
	            }
	            stack.push(c);
	        } else if (c == ')') {
	            stack.push(c);
	        } else if (c == '(') {
	            while (!stack.isEmpty() && stack.peek() != ')') {
	                prefix.append(stack.pop());
	            }
	            stack.pop();
	        } else {
	            prefix.append(c);
	        }
	    }
	    while (!stack.isEmpty()) {
	        prefix.append(stack.pop());
	    }
	    return prefix.reverse().toString();
	}

	public static int precedence(char c) {
	    switch (c) {
	        case '+':
	        case '-':
	            return 1;
	        case '*':
	        case '/':
	            return 2;
	    }
	    return -1;
	}
}
