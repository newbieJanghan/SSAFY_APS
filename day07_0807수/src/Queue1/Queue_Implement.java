package Queue1;

public class Queue_Implement {
	// 배열 사이즈가 10이면 10번 삽입할 수 있다.
	// 원소 10개를 들고 있을 수 있다? X
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) {

	}

	static boolean isEmpty() {
		return front == rear;
	}

	static boolean isFull() {
		return rear == queue.length - 1;
	}

	static boolean enQueue(String item) {
		if (isFull()) {
			return false;
		}
		queue[++rear] = item;
		return true;
	}

	static String deQueue() {
		if (isEmpty()) {
			return null;
		}
		return queue[++front];
	}
}
