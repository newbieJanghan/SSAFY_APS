package LinkedList;

public class LinkedListStack<T> {
	Node<T> top;

	void push(T value) {
		Node<T> newNode = new Node<T>(value);
		if (top != null) {
			newNode.link = top;
		}

		top = newNode;
	}

	T pop() {
		if (top == null) {
			return null;
		}
		
		T value = top.value;
		top = top.link;

		return value;
	}
}