package Stack2;

import java.util.ArrayList;

public class Stack<T> {
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