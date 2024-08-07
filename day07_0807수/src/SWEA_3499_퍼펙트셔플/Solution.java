package SWEA_3499_퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Queue<String> fQueue = new LinkedList<>();
			Queue<String> bQueue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				if (i < (double) N / 2) {
					fQueue.add(sc.next());
				} else {
					bQueue.add(sc.next());
				}
			}

			System.out.print("#" + t);
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					System.out.print(" " + fQueue.poll());
				} else {
					System.out.print(" " + bQueue.poll());
				}
			}
			System.out.println();
		}
	}
}