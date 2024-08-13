package LinkedList;

public class LinkedListQueue<T> {
	Node<T> front;
	Node<T> rear;

	boolean isEmpty() {
		return front == null;
	}

	void enQueue(T value) {
		Node<T> newNode = new Node<T>(value);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		}

		else {
			rear.link = newNode;
			rear = newNode;
		}
	}

	T deQueue() {
		if (isEmpty()) {
			return null;
		}

		T value = front.value;
		front = front.link;

		if (isEmpty()) {
			rear = null;
		}

		return value;
	}
}