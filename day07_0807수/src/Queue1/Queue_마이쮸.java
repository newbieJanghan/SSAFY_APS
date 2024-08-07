package Queue1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
	int no;
	String name;
	int quantity;

	public Customer(int no, String name, int quantity) {
		this.no = no;
		this.name = name;
		this.quantity = quantity;
	}
	
	public void satisfied() {
		quantity++;
	}

	@Override
	public String toString() {
		return "Customer [no=" + no + ", name=" + name + ", quantity=" + quantity + "]";
	}

}

public class Queue_마이쮸 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Queue<Customer> queue = new LinkedList<>();

		// 전체 마이쮸 개수
		int N = 20;
		int cNum = 1;

		queue.add(new Customer(cNum++, "Luna", 1));

		while (N > 0) {
			Customer cs = queue.poll();
			N -= cs.quantity;
			System.out.println(cs.name + "님이 마이쮸를 " + cs.quantity + "개 구매하셨습니다.");
			System.out.println("현재 매장에 " + N +"개 마이쮸가 남아있습니다.");
			
			if (N <=0) {
				System.out.println(cs.name+ "님이 막타");
				break;
			}
			
			// 맛있어서 구매 개수 추가 후 재방문
			cs.satisfied();
			queue.offer(cs);
			
			// 바이럴
			System.out.println("이 가게를 누구에게 알려줄까요? 없다면 NO를 입력해주세요");
			String newMember = sc.next();
			if (!newMember.equals("NO")) {
				queue.add(new Customer(cNum++, newMember, 1));
			}
		}
	}
}
