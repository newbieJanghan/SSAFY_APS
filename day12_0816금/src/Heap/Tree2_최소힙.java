package Heap;

public class Tree2_최소힙 {
	static int[] heap = new int[100];
	static int heapSize = 0;

	public static void main(String[] args) {
		heapPush(1);
		heapPush(20);
		heapPush(14);
		heapPush(39);
		heapPush(50);
		heapPush(-18);
		
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		
	}

	static void heapPush(int data) {
		if (heapSize == 99) {
			return;
		}
		// tree 를 배열로 표현할 때 시작 인덱스는 1
		heap[++heapSize] = data; // 1. 완전 이진 트리에 데이터 추가

		int p = heapSize / 2;
		int ch = heapSize;

		while (ch != 1 && heap[p] > heap[ch]) {
			swap(p, ch); // 2. swap

			ch = p; // 3. update index for next swap
			p = ch / 2;
		}
	}

	static int heapPop() {
		int popItem = heap[1]; // 1. 루트 데이터
		heap[1] = heap[heapSize--]; // 2. 마지막 노드를 루트로

		int p = 1;
		int ch = p * 2;
		if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1]) {
			ch = ch + 1; // 3. 자식 두 개 중 최소 자식을 할당
		}
		
		while (ch <= heapSize && heap[p] > heap[ch]) {
			swap(p, ch); // 4. swap

			p = ch; // 5. update index for next
			ch = p * 2;
			if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1]) {
				ch = ch + 1;
			}
		}
		

		return popItem;
	}

	private static void swap(int idx1, int idx2) {
		int temp = heap[idx1];
		heap[idx1] = heap[idx2];
		heap[idx2] = temp;
	}
}
