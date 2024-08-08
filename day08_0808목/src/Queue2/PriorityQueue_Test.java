package Queue2;

public class PriorityQueue_Test {
	public static void main(String[] args) {
		PriorityQueue_Array pq = new PriorityQueue_Array();
		pq.enQueue(3);
		pq.enQueue(4);
		pq.enQueue(7);
		
		System.out.println(pq.deQueue());
		System.out.println(pq.deQueue());
	}
}
