package Stack2;
import java.util.HashMap;
import java.util.Map;

public class Stack2_계산기 {
	public static void main(String[] args) {
		String expression = "(6+5*(2-8)/2)";
//		String expression = "(3+5)*8";
		String postfix = infixToPostfix(expression);
		System.out.println(postfix + " = " + calculate(postfix));
	}

	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}

	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack stack = new Stack();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;
	}

	static int calculate(String postfix) {
		Stack2 stack = new Stack2();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else if (!stack.isEmpty()) {
				int b = stack.pop();
				int a = stack.pop();
				int result = 0;

				switch (c) {
				case '+':
					result = (a + b);
					break;
				case '-':
					result = (a - b);
					break;
				case '*':
					result = (a * b);
					break;
				case '/':
					result = (a / b);
					break;
				}
				
				stack.push(result);
			}
		}

		return stack.pop();
	}

	static class Stack {
		private char[] list = new char[100];
		private int top = -1;

		public void push(char c) {
			list[++top] = c;
		}

		public char pop() {
			return list[top--];
		}

		public char peek() {
			return list[top];
		}

		public boolean isEmpty() {
			return top == -1;
		}
	}
	
	static class Stack2 {
		private int[] list = new int[100];
		private int top = -1;

		public void push(int c) {
			list[++top] = c;
		}

		public int pop() {
			return list[top--];
		}

		public int peek() {
			return list[top];
		}

		public boolean isEmpty() {
			return top == -1;
		}
	}
}
