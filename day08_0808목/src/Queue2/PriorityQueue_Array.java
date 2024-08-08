package Queue2;

public class PriorityQueue_Array {
	private int[] queue = new int[10];
	private int front = -1;
	private int rear = -1;

	public void enQueue(int item) {
		int i = ++rear;
		int j;
		for (j = i - 1; j >= 0 && queue[j] < item; j--) {
			queue[j + 1] = queue[j];
		}
		queue[j + 1] = item;
	}

	public int deQueue() {
		int value = queue[++front];
		queue[front] = 0;
		
		return value;
	}
}
