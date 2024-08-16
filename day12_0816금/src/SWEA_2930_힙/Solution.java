package SWEA_2930_힙;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t);
			MaximumHeap heap = new MaximumHeap(sb);

			int commandCnt = sc.nextInt();
			while (commandCnt-- > 0) {
				int command = sc.nextInt();
				if (command == 1) {
					heap.push(sc.nextInt());
				} else {
					heap.pop();
				}
			}

			System.out.println(sb);

		}
	}

	static class MaximumHeap {
		int[] heap = new int[1000001];
		int heapSize = 0;
		private StringBuilder sb;

		MaximumHeap(StringBuilder sb) {
			this.sb = sb;
		}

		void push(int value) {
			heap[++heapSize] = value;

			int p = heapSize / 2;
			int ch = heapSize;

			while (ch != 1 && heap[p] < heap[ch]) {
				swap(p, ch);

				ch = p;
				p = ch / 2;
			}
		}

		void pop() {
			if (heapSize == 0) {
				sb.append(" " + -1);
				return;
			}

			int max = heap[1];
			heap[1] = heap[heapSize];
			heap[heapSize--] = 0;

			int p = 1;
			int ch = p * 2;
			if (ch <= heapSize && ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch = ch + 1;
			}

			while (ch <= heapSize && heap[p] < heap[ch]) {
				swap(p, ch);

				p = ch;
				ch = p * 2;
				if (ch <= heapSize && ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
					ch = ch + 1;
				}
			}

			sb.append(" " + max);
		}

		private void swap(int i, int j) {
			int temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
	}

}