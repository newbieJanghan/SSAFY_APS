package Queue2;

import java.util.Arrays;

/**
 * 선형 큐에서는 front 와 rear 값이 같은 경우 큐가 비어있는지 꽉 차있는지 구별이 어려운 문제가 있음. 0807 자에는 size
 * 변수로 이 문제를 해결하였는데 0808 에서는 front 가 있는 자리를 항상 비워두는 방식을 적용하고자 함.
 */
public class CircularQueue {
	private int PACKET = 4;
	private int[] queue = new int[PACKET];
	private int front = 0;
	private int rear = 0;

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (front - rear + queue.length) % queue.length == 1;
	}

	public void enQueue(int item) {
		if (isFull()) {
			extend();
		}
		
		rear = (rear + 1) % queue.length;
		queue[rear] = item;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return queue[(front + 1) % queue.length];
	}

	public int deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("EMPTY");
		}
		
		// size() 는 항상 배열의 길이보다 1 작기 때문에,
		// 배열의 크기 유효성을 따지기 위해서 size 값에 1을 더한다.
		if (PACKET < queue.length && this.size() + 1 < queue.length - PACKET) {
			shorten();
		}

		front = (front + 1) % queue.length;
		int temp = queue[front];
		queue[front] = 0; // 기존 값 초기화

		return temp;
	}

	private int size() {
		if (front <= rear) {
			return rear - front;
		}
		return rear - front + queue.length;
	}

	private void extend() {
		int[] newList = new int[queue.length + PACKET];
		int tempSize = queue.length - front;
		System.arraycopy(queue, front, newList, 0, tempSize);

		// rear 가 front 뒤에 있는 경우
		if (rear == front - 1) {
			System.arraycopy(queue, 0, newList, tempSize, front);
			// rear 값 보정을 위한 size 증가
			tempSize++;
		}

		queue = newList;front = 0;
		rear = front + tempSize - 1;
	}

	private void shorten() {
		int[] newList = new int[queue.length - PACKET];
		System.arraycopy(queue, front, newList, 0, this.size());

		queue = newList;
		front = 0;
		rear = front + this.size() - 1;
	}

	void print() {
		System.out.println("front: " + front + " rear: " + rear + " size: " + size());
		System.out.println(Arrays.toString(this.queue));
	}
}
