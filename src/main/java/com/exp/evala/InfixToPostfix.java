package com.exp.evala;

import java.util.Stack;

public class InfixToPostfix {
  public static String infixToPostfix(String expression) {
    String result = "";
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      // If the character is an operand, add it to the result string
      if (Character.isLetterOrDigit(c)) {
        result += c;
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
          result += stack.pop();
        }
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
    		
    		
  }

  private static int prec(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

}
