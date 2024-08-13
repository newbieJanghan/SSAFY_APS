package singly;

class Node {
	String data;
	Node link;

	Node(String data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		this.head = new Node(null);
		this.size = 0;
	}

	void addData(int i, String data) {
		if (i < 0 || i > this.size) {
			return;
		}

		Node newNode = new Node(data);
		Node prev = head;
		for (int j = 0; j < i; j++) {
			prev = prev.link;
		}

		newNode.link = prev.link;
		prev.link = newNode;

		size++;
	}

	void removeData(int i) {
		if (i < 0 || i >= this.size) {
			return;
		}

		Node prev = head;
		for (int j = 0; j < i; j++) {
			prev = prev.link;
		}

		prev.link = prev.link.link;

		size--;
	}

}

public class LinkedList_단순연결리스트 {

}
