package SWEA_1966_숫자를정렬하자;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			PriorityQueue<Integer> queue = new PriorityQueue<>(N, (a, b) -> a - b);
			while (N-- > 0) {
				queue.add(sc.nextInt());
			}

			System.out.print("#" + t);
			while (queue.size() != 0) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();

		}
	}
}