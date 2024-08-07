package SWEA_1225_암호생성기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		while (T-- > 0) {
			int t = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();

			int N = 8;
			while (N-- > 0) {
				queue.add(sc.nextInt());
			}

			int subtractor = 1;
			Integer polled = queue.poll();
			while (polled >= 0) {
				if (subtractor > 5) {
					subtractor = 1;
				}
				Integer changed = polled - subtractor++;
				if (changed <= 0) {
					queue.add(0);
					break;
				}
				queue.add(changed);
				polled = queue.poll();
			}

			System.out.print("#" + t);
			queue.forEach((i) -> System.out.print(" " + i));
			System.out.println();
		}

	}
}