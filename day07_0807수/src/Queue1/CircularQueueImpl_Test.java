package Queue1;

import java.util.Scanner;

public class CircularQueueImpl_Test {
	public static void main(String[] args) throws Exception {
		IntCircularQueue queue = new IntCircularQueue();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Input: ");
			int num = sc.nextInt();
			if (num == -1) {
				queue.deQueue();
			} else {
				queue.enQueue(num);
			}
		}

	}
}

class IntCircularQueue {
	private int PACKET = 4;
	private int[] queue = new int[PACKET];
	private int front = -1;
	private int rear = -1;
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	boolean isFull() {
		return size == queue.length;
	}

	void resize() {
		if (size == queue.length) {
			extend();
		}

		if (PACKET < queue.length && size < queue.length - PACKET) {
			shorten();
		}
	}

	void extend() {
		int[] newList = new int[queue.length + PACKET];
		int tempSize = queue.length - (front + 1);
		System.arraycopy(queue, front + 1, newList, 0, tempSize);

		// 원형 큐로 채워진 경우
		if (rear == front) {
			System.arraycopy(queue, 0, newList, tempSize, front + 1);
		}

		queue = newList;
		front = -1;
		rear = front + size;
	}

	void shorten() {
		int[] newList = new int[queue.length - PACKET];
		System.arraycopy(queue, front + 1, newList, 0, size);

		queue = newList;
		front = -1;
		rear = front + size;
	}

	void enQueue(int item) {
		resize();
		
		rear = (rear + 1) % queue.length;
		queue[rear] = item;
	}

	int deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("EMPTY");
		}
		resize();
		size--;
		front = (front + 1) % queue.length;
		int temp = queue[front];
		queue[front] = 0; // 기존 값 초기화
		return temp;
	}
}