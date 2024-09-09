package 위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSortQueue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V + 1][V + 1];
		int[] degree = new int[V + 1]; // 진입 차수를 저장할 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjArr[A][B] = 1;
			degree[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int from = queue.poll();
			System.out.println(cook[from]);
			for (int to = 1; to < V + 1; to++) {
				if (adjArr[from][to] == 1) {
					degree[to]--;
					if (degree[to] == 0) {
						queue.add(to);
					}
				}
			}
		}

	}

	static String input = "9 9\r\n" + "	1 4\r\n" + "	1 8\r\n" + "	2 3\r\n" + "	4 3\r\n" + "	8 5\r\n"
			+ "	3 5\r\n" + "	5 6\r\n" + "	9 6\r\n" + "	6 7";
}