package Stack1;

public class Solution {
	static String[] stack = new String[100];
	static int top = -1;

	public static void main(String[] args) {
		push("고양이");
		push("토끼");
		push("쥐");
		
		while(!isEmpty()) {
			System.out.println(pop());
		}

	}

	static boolean isEmpty() {
		return top == -1;
	}

	static boolean isFull() {
		return top == stack.length - 1;
	}

	static void push(String string) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = string;
	}

	static String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top--];
	} 		
	
	static String peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}