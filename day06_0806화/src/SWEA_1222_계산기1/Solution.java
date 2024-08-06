package SWEA_1222_계산기1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String infix = sc.next();
			System.out.println("#" + t + " " + calPostfix(infixToPostfix(infix)));
		}
	}
	
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if ('0' <= c && c <= '9') {
				postfix += c;
				if (!stack.empty()) {
					postfix += stack.pop();
				}
			} else {
				stack.push(c);
			}
		}

		return postfix;
	}

	static int calPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else if (!stack.empty()) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(b + a);
			}
		}

		return stack.pop();
	}
	
	static class Stack<T> {
		private ArrayList<T> list = new ArrayList<>();
		private int top = -1;

		public void push(T obj) {
			list.add(obj);
			top++;
		}

		public T pop() {
			return list.remove(top--);
		}

		public T peek() {
			return list.get(top);
		}

		public boolean empty() {
			return top == -1;
		}
	}
}