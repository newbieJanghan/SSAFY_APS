package exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SWEA_5656_벽돌_깨기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();

		Deque<Node>[] map = new ArrayDeque[H];
		for (int w = 0; w < W; w++) {
			for (int h = 0; h < H; h++) {
				// deque 의 size 만큼 층고를 이해할 수 있도록
				map[w].add(new Node(sc.nextInt(), w, H - h));
			}
		}
	}

	static class Node {
		int value;
		int w;
		int h;

		Node(int value, int w, int h) {
			this.value = value;
			this.w = w;
			this.h = h;
		}
	}
}
