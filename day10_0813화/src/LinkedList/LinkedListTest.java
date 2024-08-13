package LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		System.out.println("stack test");
		stack.push(3);
		stack.push(6);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.push(9);
		System.out.println(stack.pop());

		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		System.out.println("queue test");
		queue.enQueue(3);
		queue.enQueue(6);
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
	}
}
