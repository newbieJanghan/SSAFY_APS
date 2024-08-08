package Queue2;

import java.util.Scanner;

public class CircularQueue_Test {
	public static void main(String[] args) throws Exception {
		CircularQueue queue = new CircularQueue();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Input: ");
			int num = sc.nextInt();
			if (num == -1) {
				queue.deQueue();
				queue.print();
			} else {
				queue.enQueue(num);
				queue.print();
			}
		}

	}
}
