package doubly;

class Node {
	String data;
	Node prev;
	Node next;

	Node(String data) {
		this.data = data;
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	DoublyLinkedList() {
		this.head = new Node(null);
		this.tail = new Node(null);
		head.next = tail;
		tail.prev = head;
	}

	void addData(int i, String data) {
		if (i < 0 || i > this.size) {
			return;
		}

		Node newNode = new Node(data);
		Node prev = head;
		for (int j = 0; j < i; j++) {
			prev = prev.next;
		}

		newNode.prev = prev;
		newNode.next = prev.next;

		prev.next.prev = newNode;
		prev.next = newNode;

		size++;
	}

	void removeData(int i) {
		if (i < 0 || i >= this.size) {
			return;
		}

		Node prev = head;
		for (int j = 0; j < i; j++) {
			prev = prev.next;
		}

		prev.next = prev.next.next;
		prev.next.prev = prev;

		size--;
	}

}

public class LinkedList_이중연결리스트 {

}
