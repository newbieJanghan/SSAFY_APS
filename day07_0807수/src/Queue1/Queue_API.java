package Queue1;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_API {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1); // exception when cannot add
		queue.offer(1); // return false
		System.out.println(queue);

		queue.remove(); // exception when cannot remove
		queue.poll(); // return null
		System.out.println(queue);

		queue.element(); // exception
		queue.peek(); // null

		System.out.println("finish");
	}
}
